package com.ecfproject.app.dataprovider.entity;

import com.ecfproject.app.dataprovider.schema.Schema;
import com.ecfproject.core.model.LegalPersonPartnerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.CREATED_AT_COLUMN_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.UPDATED_AT_COLUMN_NAME;
import static javax.persistence.EnumType.ORDINAL;

@Value
@AllArgsConstructor
@Builder
@Entity(name = Schema.LEGAL_PERSON_PARTNER_TABLE_NAME)
public class LegalPersonPartnerEntity {

  @Id
  @GeneratedValue
  Long id;

  @Column(nullable = false, name = Schema.CommonColumn.NATURAL_PERSON_ID_COLUMN_NAME)
  Long naturalPersonId;

  @Column(nullable = false, name = Schema.CommonColumn.LEGAL_PERSON_ID_COLUMN_NAME)
  Long legalPersonId;

  @Column(nullable = false, length = 20)
  @Enumerated(ORDINAL)
  LegalPersonPartnerType type;

  @Column(nullable = false, name = CREATED_AT_COLUMN_NAME)
  OffsetDateTime createdAt;

  @Column(nullable = false, name = UPDATED_AT_COLUMN_NAME)
  OffsetDateTime updatedAt;

}
