package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.NaturalPersonEntity;
import com.ecfproject.core.model.NaturalPerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import static com.ecfproject.core.model.GenderType.MALE;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(NaturalPersonMapperImpl.class)
class NaturalPersonMapperTest {

  @Autowired
  private transient NaturalPersonMapper mapper;

  @Test
  void entityToModel() {
    final NaturalPersonEntity target = NaturalPersonEntity
      .builder()
      .id(1L)
      .name("name")
      .document("123")
      .birthDate(LocalDate.now())
      .gender(MALE)
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final NaturalPerson actual = mapper.entityToModel(target);

    assertThat(actual).isNotNull();
    assertThat(actual.getAddress()).isNull();
    assertThat(actual.getContact()).isNull();
  }

  @Test
  void modelToEntity() {
    final NaturalPerson target = NaturalPerson
      .builder()
      .id(1L)
      .name("name")
      .document("123")
      .birthDate(LocalDate.now())
      .gender(MALE)
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final NaturalPersonEntity actual = mapper.modelToEntity(target);

    assertThat(actual).isNotNull();
  }
}
