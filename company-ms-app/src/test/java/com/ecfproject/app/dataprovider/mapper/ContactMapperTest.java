package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.ContactEntity;
import com.ecfproject.core.model.Contact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.OffsetDateTime;

import static com.ecfproject.core.model.ContactType.EMAIL;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@Import(ContactMapperImpl.class)
class ContactMapperTest {

  @Autowired
  private transient ContactMapper mapper;

  @Test
  void entityToModel() {
    final ContactEntity target = ContactEntity
      .builder()
      .id(1L)
      .type(EMAIL)
      .value("value@email.com")
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final Contact actual = mapper.entityToModel(target);

    assertThat(actual).isNotNull();
  }

  @Test
  void modelToEntity() {
    final Contact target = Contact
      .builder()
      .id(1L)
      .type(EMAIL)
      .value("value@email.com")
      .createdAt(OffsetDateTime.now())
      .updatedAt(OffsetDateTime.now())
      .build();

    final ContactEntity actual = mapper.modelToEntity(target);

    assertThat(actual).isNotNull();
  }
}
