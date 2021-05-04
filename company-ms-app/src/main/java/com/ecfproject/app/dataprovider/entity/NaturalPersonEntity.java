package com.ecfproject.app.dataprovider.entity;

import com.ecfproject.app.dataprovider.schema.Schema;
import com.ecfproject.core.model.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.EnumType.STRING;

@Value
@AllArgsConstructor
@Builder
@Entity(name = Schema.NATURAL_PERSON_TABLE_NAME)
public class NaturalPersonEntity {

  @Id
  @GeneratedValue
  Long id;

  @Column(nullable = false, length = 200)
  String name;

  @Column(nullable = false, length = 11)
  String document;

  @Column(nullable = false, name = Schema.NaturalPersonColumn.BIRTH_DATE_COLUMN_NAME)
  LocalDate birthDate;

  @Column(nullable = false, length = 40)
  @Enumerated(STRING)
  GenderType gender;

  @Column(nullable = false, name = Schema.CommonColumn.CREATED_AT_COLUMN_NAME)
  OffsetDateTime createdAt;

  @Column(nullable = false, name = Schema.CommonColumn.UPDATED_AT_COLUMN_NAME)
  OffsetDateTime updatedAt;

}
