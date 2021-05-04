package com.ecfproject.core.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

@Value
@EqualsAndHashCode(callSuper = false)
@Builder
public class LegalPerson {

  Long id;
  String name;
  String tradingName;
  String document;
  LegalPersonType type;
  LocalDate openingDate;
  Address address;
  Contact contact;
  Set<LegalPersonPartner> partners;
  OffsetDateTime createdAt;
  OffsetDateTime updatedAt;

}
