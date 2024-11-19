package com.example.distributed_cache_node.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheEntryPutDto {
  private @NonNull String value;
}
