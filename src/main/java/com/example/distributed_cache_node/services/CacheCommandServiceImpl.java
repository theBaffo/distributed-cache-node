package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Profile("command")
@Service
public class CacheCommandServiceImpl implements CacheCommandService {
  @Autowired private StringRedisTemplate redisTemplate;

  @Override
  public CacheEntry put(String key, String value) {
    redisTemplate.opsForValue().set(key, value);

    return new CacheEntry(key, value);
  }

  @Override
  public CacheEntry delete(String key) throws CacheEntryNotFoundException {
    String value = redisTemplate.opsForValue().getAndDelete(key);

    if (value == null) {
      throw new CacheEntryNotFoundException(key);
    }

    return new CacheEntry(key, value);
  }
}
