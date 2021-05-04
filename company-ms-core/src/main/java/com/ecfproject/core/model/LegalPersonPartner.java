package com.ecfproject.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;

@Value
@AllArgsConstructor
@Builder
public class LegalPersonPartner {

  Long id;
  Long legalPersonId;
  NaturalPerson naturalPerson;
  LegalPersonPartnerType type;
  OffsetDateTime createdAt;
  OffsetDateTime updatedAt;

}
