package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.models.CacheEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheQueryServiceImpl implements CacheQueryService {
  @Autowired private StringRedisTemplate redisTemplate;

  @Override
  public CacheEntry get(String key) {
    String value = redisTemplate.opsForValue().get(key);

    // TODO Implement
    var entry = new CacheEntry(key, value);
    return entry;
  }
}
