package com.example.distributed_cache_node;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.dtos.CacheEntryPutDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DistributedCacheNodeApplicationTests {
  @Autowired private MockMvc mockMvc;

  @Autowired private ObjectMapper objectMapper;

  @Test
  void contextLoads() {}

  @Test
  void putTest() throws Exception {
    // Arrange
    String key = UUID.randomUUID().toString();

    CacheEntryPutDto cacheEntryPutDto = new CacheEntryPutDto("value");
    CacheEntryDto expectedResult = new CacheEntryDto(key, "value");

    // Act & Assert
    this.mockMvc
        .perform(
            put("/cache/" + key)
                .content(objectMapper.writeValueAsString(cacheEntryPutDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)))
        .andReturn();
  }

  @Test
  void deleteTest() throws Exception {
    // Arrange
    String key = UUID.randomUUID().toString();

    CacheEntryPutDto cacheEntryPutDto = new CacheEntryPutDto("value");
    CacheEntryDto expectedResult = new CacheEntryDto(key, "value");

    // Create the cache entry first
    this.mockMvc
        .perform(
            put("/cache/" + key)
                .content(objectMapper.writeValueAsString(cacheEntryPutDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)));

    // Act & Assert
    this.mockMvc
        .perform(delete("/cache/" + key))
        .andExpect(status().isOk())
        .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)));
  }

  @Test
  void getTest() throws Exception {
    // Arrange
    String key = UUID.randomUUID().toString();

    CacheEntryPutDto cacheEntryPutDto = new CacheEntryPutDto("value");
    CacheEntryDto expectedResult = new CacheEntryDto(key, "value");

    // Create the cache entry first
    this.mockMvc
        .perform(
            put("/cache/" + key)
                .content(objectMapper.writeValueAsString(cacheEntryPutDto))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)));

    // Act & Assert
    this.mockMvc
        .perform(get("/cache/" + key))
        .andExpect(status().isOk())
        .andExpect(content().string(objectMapper.writeValueAsString(expectedResult)));
  }

  @Test
  void deleteNotFoundTest() throws Exception {
    // Arrange
    String key = UUID.randomUUID().toString();

    // Act & Assert
    this.mockMvc
        .perform(delete("/cache/" + key))
        .andExpect(status().isNotFound())
        .andExpect(content().string(new CacheEntryNotFoundException(key).getMessage()));
  }

  @Test
  void getNotFoundTest() throws Exception {
    // Arrange
    String key = UUID.randomUUID().toString();

    // Act & Assert
    this.mockMvc
        .perform(get("/cache/" + key))
        .andExpect(status().isNotFound())
        .andExpect(content().string(new CacheEntryNotFoundException(key).getMessage()));
  }
}
