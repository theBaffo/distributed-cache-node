package com.example.distributed_cache_node.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

public class ErrorUtils {
  public static List<String> getFieldsFromErrors(Errors errors) {
    List<String> result = new ArrayList<>();

    for (FieldError error : errors.getFieldErrors()) {
      result.add(error.getField());
    }

    return result;
  }
}
