package com.example.distributed_cache_node.controllers;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;
import com.example.distributed_cache_node.services.CacheQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheQueryController {
  private CacheQueryService cacheQueryService;

  public CacheQueryController(CacheQueryService cacheQueryService) {
    this.cacheQueryService = cacheQueryService;
  }

  // TODO return DTO
  @GetMapping("/{key}")
  public CacheEntry getCacheEntry(@PathVariable("key") String key)
      throws CacheEntryNotFoundException {
    return cacheQueryService.get(key);
  }
}
