package com.example.distributed_cache_node.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CacheEntryDto {
  private String key;
  private String value;
}
