package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;

public interface CacheCommandService {
  CacheEntry put(String key, String value);
  CacheEntry delete(String key) throws CacheEntryNotFoundException;
}
