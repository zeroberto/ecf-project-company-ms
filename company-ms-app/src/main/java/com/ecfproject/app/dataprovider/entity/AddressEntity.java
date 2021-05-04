package com.ecfproject.app.dataprovider.entity;

import com.ecfproject.app.dataprovider.schema.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = Schema.ADDRESS_TABLE_NAME)
public class AddressEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column(nullable = false, length = 120)
  private String street;

  @Column(nullable = false, length = 20)
  private String number;

  @Column(length = 120)
  private String complement;

  @Column(nullable = false, length = 100)
  private String neighborhood;

  @Column(nullable = false, length = 100)
  private String city;

  @Column(nullable = false, length = 100)
  private String state;

  @Column(nullable = false, length = 100)
  private String country;

  @Column(nullable = false, name = Schema.CommonColumn.CREATED_AT_COLUMN_NAME)
  private OffsetDateTime createdAt;

  @Column(nullable = false, name = Schema.CommonColumn.UPDATED_AT_COLUMN_NAME)
  private OffsetDateTime updatedAt;

}
