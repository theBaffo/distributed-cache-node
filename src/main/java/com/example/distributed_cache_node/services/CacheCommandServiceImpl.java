package com.example.distributed_cache_node.services;

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

    var entry = new CacheEntry(key, value);
    return entry;
  }
}
