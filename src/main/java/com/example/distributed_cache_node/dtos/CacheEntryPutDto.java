package com.example.distributed_cache_node.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class CacheEntryPutDto {
  private @NonNull String value;
}
