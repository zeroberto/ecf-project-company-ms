package com.ecfproject.core.usecase;

import com.ecfproject.core.dataprovider.LegalPersonDataProvider;
import com.ecfproject.core.model.LegalPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.Set;

import static com.ecfproject.core.model.LegalPersonType.HEADQUARTERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LegalPersonUseCaseTest {

  private transient LegalPersonUseCase legalPersonUseCase;

  @Mock
  private transient LegalPersonDataProvider legalPersonDataProvider;

  @BeforeEach
  void setUp() {
    this.legalPersonUseCase = new LegalPersonUseCaseDefault(legalPersonDataProvider);
  }

  @Test
  void list() {
    final int expectedSize = 1;

    when(legalPersonDataProvider.findAll())
      .thenReturn(Set.of(stub()));

    assertThat(legalPersonUseCase.list())
      .hasSize(expectedSize);
  }

  @Test
  void find() {
    final Long targetId = 1L;

    when(legalPersonDataProvider.findById(anyLong()))
      .thenReturn(Optional.of(stub()));

    assertThat(legalPersonUseCase.find(targetId))
      .isNotNull();
  }

  @Test
  void save() {
    final var targetLegalPerson = stub();

    when(legalPersonDataProvider.save(any()))
      .thenReturn(targetLegalPerson);

    assertThat(legalPersonUseCase.save(targetLegalPerson))
      .isNotNull();
  }

  private LegalPerson stub() {
    return LegalPerson
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
  }
}
