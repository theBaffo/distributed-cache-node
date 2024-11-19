package com.example.distributed_cache_node.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.mappers.CacheMapper;
import com.example.distributed_cache_node.models.CacheEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@ExtendWith(MockitoExtension.class)
public class CacheCommandServiceImplTests {
  @Mock private StringRedisTemplate stringRedisTemplate;
  @Mock private ValueOperations<String, String> valueOperations;
  @Mock private CacheMapper cacheMapper;

  @BeforeAll
  static void setup() {}

  @Test
  void putTest() {
    // Arrange
    CacheEntry cacheEntry = new CacheEntry("key", "value");
    CacheEntryDto cacheEntryDto = new CacheEntryDto("key", "value");

    when(stringRedisTemplate.opsForValue()).thenReturn(valueOperations);
    when(cacheMapper.convertToDto(cacheEntry)).thenReturn(cacheEntryDto);

    // Act
    CacheCommandService service =
        new CacheCommandServiceImpl(this.stringRedisTemplate, this.cacheMapper);
    CacheEntryDto cacheEntryResult = service.put("key", "value");

    // Assert
    assertNotNull(cacheEntryResult);
    assertEquals(cacheEntryDto, cacheEntryResult);
  }

  @Test
  void deleteTest() throws CacheEntryNotFoundException {
    // Arrange
    CacheEntry cacheEntry = new CacheEntry("key", "value");
    CacheEntryDto cacheEntryDto = new CacheEntryDto("key", "value");

    when(stringRedisTemplate.opsForValue()).thenReturn(valueOperations);
    when(valueOperations.getAndDelete("key")).thenReturn("value");
    when(cacheMapper.convertToDto(cacheEntry)).thenReturn(cacheEntryDto);

    // Act
    CacheCommandService service =
        new CacheCommandServiceImpl(this.stringRedisTemplate, this.cacheMapper);
    CacheEntryDto cacheEntryResult = service.delete("key");

    // Assert
    assertNotNull(cacheEntryResult);
    assertEquals(cacheEntryDto, cacheEntryResult);
  }

  @Test
  void deleteNotFoundTest() throws CacheEntryNotFoundException {
    // Arrange
    when(stringRedisTemplate.opsForValue()).thenReturn(valueOperations);
    when(valueOperations.getAndDelete("key")).thenReturn(null);

    // Act
    CacheCommandService service =
        new CacheCommandServiceImpl(this.stringRedisTemplate, this.cacheMapper);

    // Assert
    Assertions.assertThrows(CacheEntryNotFoundException.class, () -> service.delete("key"));
  }
}
