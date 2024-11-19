package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;

public interface CacheQueryService {
  CacheEntryDto get(String key) throws CacheEntryNotFoundException;
}
