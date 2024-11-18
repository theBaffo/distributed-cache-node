package com.example.distributed_cache_node.exceptions;

public class CacheEntryNotFoundException extends Exception {
  public CacheEntryNotFoundException(String key) {
    super(String.format("Cache entry with key %s was not found", key));
  }
}
