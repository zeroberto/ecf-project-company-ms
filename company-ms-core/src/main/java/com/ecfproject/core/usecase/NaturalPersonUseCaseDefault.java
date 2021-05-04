package com.ecfproject.core.usecase;

import com.ecfproject.core.dataprovider.NaturalPersonDataProvider;
import com.ecfproject.core.model.NaturalPerson;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import javax.inject.Named;

@Named
@RequiredArgsConstructor
public class NaturalPersonUseCaseDefault implements NaturalPersonUseCase {

  private final NaturalPersonDataProvider dataProvider;

  @Override
  public NaturalPerson find(final Long id) {
    return dataProvider
      .findById(id)
      .orElseThrow();
  }

  @Override
  public Set<NaturalPerson> list() {
    return dataProvider.findAll();
  }

  @Override
  public NaturalPerson save(final NaturalPerson naturalPerson) {
    return dataProvider.save(naturalPerson);
  }
}
