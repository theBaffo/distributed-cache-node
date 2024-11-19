package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.mappers.CacheMapper;
import com.example.distributed_cache_node.models.CacheEntry;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Profile("query")
@Service
@AllArgsConstructor
public class CacheQueryServiceImpl implements CacheQueryService {
  private StringRedisTemplate stringRedisTemplate;
  private CacheMapper cacheMapper;

  @Override
  public CacheEntryDto get(String key) throws CacheEntryNotFoundException {
    String value = stringRedisTemplate.opsForValue().get(key);

    if (value == null) {
      throw new CacheEntryNotFoundException(key);
    }

    return cacheMapper.convertToDto(new CacheEntry(key, value));
  }
}
