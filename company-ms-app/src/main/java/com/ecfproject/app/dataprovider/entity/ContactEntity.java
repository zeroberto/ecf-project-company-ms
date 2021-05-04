package com.ecfproject.app.dataprovider.entity;

import com.ecfproject.core.model.ContactType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static com.ecfproject.app.dataprovider.schema.Schema.CONTACT_TABLE_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.CREATED_AT_COLUMN_NAME;
import static com.ecfproject.app.dataprovider.schema.Schema.CommonColumn.UPDATED_AT_COLUMN_NAME;
import static javax.persistence.EnumType.STRING;

@Value
@AllArgsConstructor
@Builder
@Entity(name = CONTACT_TABLE_NAME)
public class ContactEntity {

  @Id
  @GeneratedValue
  Long id;

  @Column(nullable = false, length = 50)
  @Enumerated(STRING)
  ContactType type;

  @Column(nullable = false, length = 100)
  String value;

  @Column(nullable = false, name = CREATED_AT_COLUMN_NAME)
  OffsetDateTime createdAt;

  @Column(nullable = false, name = UPDATED_AT_COLUMN_NAME)
  OffsetDateTime updatedAt;

}
