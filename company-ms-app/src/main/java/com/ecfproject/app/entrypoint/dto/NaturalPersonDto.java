package com.ecfproject.app.entrypoint.dto;

import com.ecfproject.core.model.Address;
import com.ecfproject.core.model.Contact;
import com.ecfproject.core.model.GenderType;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Value
public class NaturalPersonDto {

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
