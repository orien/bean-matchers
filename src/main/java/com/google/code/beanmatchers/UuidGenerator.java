package com.google.code.beanmatchers;

import java.util.UUID;

class UuidGenerator implements ValueGenerator<UUID> {
  public UUID generate() {
    return UUID.randomUUID();
  }
}
