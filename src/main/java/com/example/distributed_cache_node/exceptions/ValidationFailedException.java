package com.example.distributed_cache_node.exceptions;

import java.util.List;

public class ValidationFailedException extends Exception {
  public ValidationFailedException(List<String> fields) {
    super(ValidationFailedException.buildMessage(fields));
  }

  public static String buildMessage(List<String> fields) {
    if (fields.size() == 1) {
      return "Field \"" + fields.get(0) + "\" is mandatory";
    } else {
      StringBuilder stringBuilder = new StringBuilder("Fields ");

      for (int i = 0; i < fields.size(); i++) {
        if (i >= 1) stringBuilder.append(" / ");

        stringBuilder.append("\"" + fields.get(i) + "\"");
      }

      stringBuilder.append(" are mandatory");
      return stringBuilder.toString();
    }
  }
}
