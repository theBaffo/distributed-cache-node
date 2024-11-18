package com.example.distributed_cache_node.dtos;

import io.micrometer.common.lang.NonNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CacheEntryPutDto {
  private @NonNull String value;
}
