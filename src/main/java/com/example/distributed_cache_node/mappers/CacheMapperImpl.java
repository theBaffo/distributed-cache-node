package com.example.distributed_cache_node.mappers;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.models.CacheEntry;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CacheMapperImpl implements CacheMapper {
  private ModelMapper modelMapper;

  @Override
  public CacheEntryDto convertToDto(CacheEntry cacheEntry) {
    return modelMapper.map(cacheEntry, CacheEntryDto.class);
  }
}
