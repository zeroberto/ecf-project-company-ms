package com.ecfproject.core.usecase;

import com.ecfproject.core.model.NaturalPerson;

import java.util.Set;

public interface NaturalPersonUseCase {

  NaturalPerson find(Long id);

  Set<NaturalPerson> list();

  NaturalPerson save(NaturalPerson naturalPerson);

}
