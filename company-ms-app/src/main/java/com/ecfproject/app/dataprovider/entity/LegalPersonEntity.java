package com.ecfproject.app.dataprovider.entity;

import com.ecfproject.core.model.LegalPersonType;
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

import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.CREATED_AT_COLUMN_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.UPDATED_AT_COLUMN_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.LEGAL_PERSON_TABLE_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.LegalPersonColumn.OPENING_DATE_COLUMN_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.LegalPersonColumn.TRADING_NAME_COLUMN_NAME;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Value
@AllArgsConstructor
@Builder
@Entity(name = LEGAL_PERSON_TABLE_NAME)
public class LegalPersonEntity {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  Long id;

  @Column(nullable = false, length = 200)
  String name;

  @Column(nullable = false, length = 200, name = TRADING_NAME_COLUMN_NAME)
  String tradingName;

  @Column(nullable = false, length = 14)
  String document;

  @Column(nullable = false, length = 100)
  @Enumerated(STRING)
  LegalPersonType type;

  @Column(nullable = false, name = OPENING_DATE_COLUMN_NAME)
  LocalDate openingDate;

  @Column(nullable = false, name = CREATED_AT_COLUMN_NAME)
  OffsetDateTime createdAt;

  @Column(nullable = false, name = UPDATED_AT_COLUMN_NAME)
  OffsetDateTime updatedAt;

}
