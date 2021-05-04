package com.ecfproject.app.entrypoint.rest;

import com.ecfproject.app.dataprovider.entity.AddressEntity;
import com.ecfproject.app.dataprovider.repository.AddressEntityRepository;
import com.ecfproject.app.test.AppIntegrationTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import static java.time.OffsetDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

@AppIntegrationTest
class LegalPersonControllerTest {

  @Autowired
  private transient AddressEntityRepository addressEntityRepository;

  @Test
  @Order(1)
  @Transactional
  void givenUsersInDB_WhenUpdateStatusForNameModifyingQueryAnnotationJPQL_ThenModifyMatchingUsers1() {
    assertThat(addressEntityRepository.findAll()).isEmpty();
  }

  @Test
  @Order(2)
  @Transactional
  void givenUsersInDB_WhenUpdateStatusForNameModifyingQueryAnnotationJPQL_ThenModifyMatchingUsers() {
    insert();
    assertThat(addressEntityRepository.findAll()).isNotEmpty();
  }

  @Test
  @Order(1)
  @Transactional
  void givenUsersInDB_WhenUpdateStatusForNameModifyingQueryAnnotationJPQL_ThenModifyMatchingUsers3() {
    assertThat(addressEntityRepository.findAll()).isEmpty();
  }

  private void insert() {
    addressEntityRepository.save(
      AddressEntity
        .builder()
        .street("street")
        .number("1")
        .complement("c")
        .neighborhood("neig")
        .city("ci")
        .state("st")
        .country("co")
        .createdAt(now())
        .updatedAt(now())
        .build());
  }
}
