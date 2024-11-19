package com.example.distributed_cache_node.controllers;

import com.example.distributed_cache_node.exceptions.CacheEntryNotFoundException;
import com.example.distributed_cache_node.exceptions.ValidationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CacheExceptionsController {
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ExceptionHandler(CacheEntryNotFoundException.class)
  @ResponseBody
  public ResponseEntity<String> handleCacheEntryNotFoundException(
      CacheEntryNotFoundException cacheEntryNotFoundException) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(cacheEntryNotFoundException.getMessage());
  }

  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ValidationFailedException.class)
  @ResponseBody
  public ResponseEntity<String> handleValidationFailedException(
      ValidationFailedException validationFailedException) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(validationFailedException.getMessage());
  }
}
