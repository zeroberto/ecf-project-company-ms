package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.LegalPersonPartnerEntity;
import com.ecfproject.core.model.LegalPersonPartner;
import com.ecfproject.core.model.NaturalPerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;

import static com.ecfproject.core.model.LegalPersonPartnerType.PARTNER;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(LegalPersonPartnerMapperImpl.class)
class LegalPersonPartnerMapperTest {

  @Autowired
  private transient LegalPersonPartnerMapper mapper;

  @Test
  void entityToModel() {
    final LegalPersonPartnerEntity target = LegalPersonPartnerEntity
      .builder()
      .id(1L)
      .legalPersonId(1L)
      .naturalPersonId(1L)
      .type(PARTNER)
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final LegalPersonPartner actual = mapper.entityToModel(target);

    assertThat(actual)
      .isNotNull();
    assertThat(actual.getNaturalPerson().getId())
      .isEqualTo(target.getNaturalPersonId());
  }

  @Test
  void modelToEntity() {
    final LegalPersonPartner target = LegalPersonPartner
      .builder()
      .id(1L)
      .legalPersonId(1L)
      .naturalPerson(NaturalPerson
        .builder()
        .id(1L)
        .build())
      .type(PARTNER)
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final LegalPersonPartnerEntity actual = mapper.modelToEntity(target);

    assertThat(actual).isNotNull();
  }
}
