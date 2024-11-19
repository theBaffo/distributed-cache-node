package com.example.distributed_cache_node.services;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;

public interface CacheCommandService {
  CacheEntryDto put(String key, String value);

  CacheEntryDto delete(String key) throws CacheEntryNotFoundException;
}
