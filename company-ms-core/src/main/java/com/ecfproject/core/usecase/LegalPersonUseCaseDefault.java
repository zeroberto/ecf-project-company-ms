package com.ecfproject.core.usecase;

import com.ecfproject.core.dataprovider.LegalPersonDataProvider;
import com.ecfproject.core.model.LegalPerson;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class LegalPersonUseCaseDefault implements LegalPersonUseCase {

  private final LegalPersonDataProvider dataProvider;

  @Override
  public LegalPerson find(final Long id) {
    return dataProvider
      .findById(id)
      .orElseThrow(() -> new ModelNotFoundException(id));
  }

  @Override
  public Set<LegalPerson> list() {
    return dataProvider.findAll();
  }

  @Override
  public LegalPerson save(final LegalPerson legalPerson) {
    return dataProvider.save(legalPerson);
  }
}
