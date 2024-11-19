package com.example.distributed_cache_node.controllers;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.services.CacheQueryService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("query")
@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheQueryController {
  private CacheQueryService cacheQueryService;

  @GetMapping("/{key}")
  public CacheEntryDto getCacheEntry(@PathVariable("key") String key)
      throws CacheEntryNotFoundException {
    return cacheQueryService.get(key);
  }
}
