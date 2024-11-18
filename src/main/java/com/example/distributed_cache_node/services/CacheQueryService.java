package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;

public interface CacheQueryService {
  CacheEntry get(String key) throws CacheEntryNotFoundException;
}
