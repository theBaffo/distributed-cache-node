package com.example.distributed_cache_node.controllers;

import com.example.distributed_cache_node.dtos.CacheEntryDto;
import com.example.distributed_cache_node.dtos.CacheEntryPutDto;
import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.exceptions.ValidationFailedException;
import com.example.distributed_cache_node.services.CacheCommandService;
import com.example.distributed_cache_node.utils.ErrorUtils;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Profile("command")
@RestController
@RequestMapping("/cache")
@AllArgsConstructor
public class CacheCommandController {
  private CacheCommandService cacheCommandService;

  @PutMapping("/{key}")
  @ResponseStatus(HttpStatus.CREATED)
  public CacheEntryDto puCacheEntry(
      @PathVariable("key") String key,
      @Validated @RequestBody CacheEntryPutDto cacheEntryPutDto,
      Errors errors)
      throws ValidationFailedException {
    if (errors != null && errors.hasErrors()) {
      throw new ValidationFailedException(ErrorUtils.getFieldsFromErrors(errors));
    }

    return cacheCommandService.put(key, cacheEntryPutDto.getValue());
  }

  @DeleteMapping("/{key}")
  public CacheEntryDto deleteCacheEntry(@PathVariable("key") String key)
      throws CacheEntryNotFoundException {
    return cacheCommandService.delete(key);
  }
}
