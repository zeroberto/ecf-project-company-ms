package com.ecfproject.core.usecase;

import com.ecfproject.core.model.LegalPerson;

import java.util.Set;
import javax.inject.Named;

@Named
public interface LegalPersonUseCase {

  LegalPerson find(Long id);

  Set<LegalPerson> list();

  LegalPerson save(LegalPerson legalPerson);

}
