package com.example.distributed_cache_node.models;

import lombok.Data;
import lombok.NonNull;

@Data
public class CacheEntry {
  private @NonNull String key;
  private @NonNull String value;
}
