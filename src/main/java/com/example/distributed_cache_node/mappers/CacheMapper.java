package com.example.distributed_cache_node.mappers;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.models.CacheEntry;

public interface CacheMapper {
  CacheEntryDto convertToDto(CacheEntry cacheEntry);
}
