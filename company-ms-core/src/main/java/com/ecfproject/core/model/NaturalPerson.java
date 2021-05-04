package com.ecfproject.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class NaturalPerson {

  Long id;
  String name;
  String document;
  LocalDate birthDate;
  GenderType gender;
  Address address;
  Contact contact;
  OffsetDateTime createdAt;
  OffsetDateTime updatedAt;

}
