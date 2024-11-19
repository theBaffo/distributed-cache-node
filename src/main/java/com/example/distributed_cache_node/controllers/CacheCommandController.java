package com.example.distributed_cache_node.controllers;

import com.example.distributed_cache_node.dtos.CacheEntryPutDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.models.CacheEntry;
import com.example.distributed_cache_node.services.CacheCommandService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Profile("command")
@RestController
@RequestMapping("/cache")
public class CacheCommandController {
  private CacheCommandService cacheCommandService;

  public CacheCommandController(CacheCommandService cacheCommandService) {
    this.cacheCommandService = cacheCommandService;
  }

  // TODO return DTO
  @PutMapping("/{key}")
  @ResponseStatus(HttpStatus.CREATED)
  public CacheEntry puCacheEntry(
      @PathVariable("key") String key, @RequestBody CacheEntryPutDto cacheEntryPutDto) {
    return cacheCommandService.put(key, cacheEntryPutDto.getValue());
  }

  // TODO return DTO
  @DeleteMapping("/{key}")
  public CacheEntry deleteCacheEntry(@PathVariable("key") String key)
      throws CacheEntryNotFoundException {
    return cacheCommandService.delete(key);
  }
}
