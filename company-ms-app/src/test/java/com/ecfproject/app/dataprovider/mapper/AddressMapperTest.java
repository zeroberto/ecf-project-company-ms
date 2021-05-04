package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.AddressEntity;
import com.ecfproject.core.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(AddressMapperImpl.class)
class AddressMapperTest {

  @Autowired
  private transient AddressMapper mapper;

  @Test
  void entityToModel() {
    final AddressEntity target = AddressEntity
      .builder()
      .id(1L)
      .street("street")
      .number("1")
      .neighborhood("neighborhood")
      .complement("complement")
      .city("city")
      .state("state")
      .country("country")
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final Address actual = mapper.entityToModel(target);

    assertThat(actual).isNotNull();
  }

  @Test
  void modelToEntity() {
    final Address target = Address
      .builder()
      .id(1L)
      .street("street")
      .number("1")
      .neighborhood("neighborhood")
      .complement("complement")
      .city("city")
      .state("state")
      .country("country")
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final AddressEntity actual = mapper.modelToEntity(target);

    assertThat(actual).isNotNull();
  }
}
