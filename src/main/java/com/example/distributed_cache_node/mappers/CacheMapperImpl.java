package com.example.distributed_cache_node.mappers;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.models.CacheEntry;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CacheMapperImpl implements CacheMapper {
  private ModelMapper modelMapper;

  public CacheMapperImpl(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public CacheEntryDto convertToDto(CacheEntry cacheEntry) {
    return modelMapper.map(cacheEntry, CacheEntryDto.class);
  }
}
