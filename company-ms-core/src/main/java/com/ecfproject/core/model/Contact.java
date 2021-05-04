package com.ecfproject.core.model;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
@Builder
public class Contact {

  Long id;
  ContactType type;
  String value;
  OffsetDateTime createdAt;
  OffsetDateTime updatedAt;

}
