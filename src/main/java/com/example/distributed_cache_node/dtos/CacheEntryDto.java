package com.example.distributed_cache_node.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheEntryDto {
  private String key;
  private String value;
}
