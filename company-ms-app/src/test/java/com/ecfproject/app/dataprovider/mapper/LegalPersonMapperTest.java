package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.LegalPersonEntity;
import com.ecfproject.core.model.LegalPerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import static com.ecfproject.core.model.LegalPersonType.HEADQUARTERS;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(LegalPersonMapperImpl.class)
class LegalPersonMapperTest {

  @Autowired
  private transient LegalPersonMapper mapper;

  @Test
  void entityToModel() {
    final LegalPersonEntity target = LegalPersonEntity
      .builder()
      .id(1L)
      .name("name")
      .tradingName("trandingName")
      .document("123")
      .type(HEADQUARTERS)
      .openingDate(LocalDate.now())
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final LegalPerson actual = mapper.entityToModel(target);

    assertThat(actual).isNotNull();
    assertThat(actual.getAddress()).isNull();
    assertThat(actual.getContact()).isNull();
  }

  @Test
  void modelToEntity() {
    final LegalPerson target = LegalPerson
      .builder()
      .id(1L)
      .name("name")
      .tradingName("trandingName")
      .document("123")
      .type(HEADQUARTERS)
      .openingDate(LocalDate.now())
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final LegalPersonEntity actual = mapper.modelToEntity(target);

    assertThat(actual).isNotNull();
  }
}
