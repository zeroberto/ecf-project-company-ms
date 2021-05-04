package com.ecfproject.core.model;

import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
@Builder
public class Address {

  Long id;
  String street;
  String number;
  String complement;
  String neighborhood;
  String city;
  String state;
  String country;
  OffsetDateTime createdAt;
  OffsetDateTime updatedAt;

}
