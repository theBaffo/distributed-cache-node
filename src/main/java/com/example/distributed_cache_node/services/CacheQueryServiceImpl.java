package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Profile("query")
@Service
public class CacheQueryServiceImpl implements CacheQueryService {
  @Autowired private StringRedisTemplate redisTemplate;

  @Override
  public CacheEntry get(String key) throws CacheEntryNotFoundException {
    String value = redisTemplate.opsForValue().get(key);

    if (value == null) {
      throw new CacheEntryNotFoundException(key);
    }

    var entry = new CacheEntry(key, value);
    return entry;
  }
}
