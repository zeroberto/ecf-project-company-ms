package com.ecfproject.app.dataprovider;

import com.ecfproject.app.dataprovider.mapper.LegalPersonMapper;
import com.ecfproject.app.dataprovider.repository.LegalPersonEntityRepository;
import com.ecfproject.core.dataprovider.LegalPersonDataProvider;
import com.ecfproject.core.model.LegalPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class LegalPersonDataProviderSql implements LegalPersonDataProvider {

  private final LegalPersonEntityRepository repository;
  private final LegalPersonMapper mapper;

  @Override
  public Set<LegalPerson> findAll() {
    return repository
      .findAll()
      .stream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Optional<LegalPerson> findById(final Long id) {
    return repository
      .findById(id)
      .map(mapper::entityToModel);
  }

  @Transactional
  @Override
  public LegalPerson save(final LegalPerson model) {
    return mapper.entityToModel(
      repository.save(mapper.modelToEntity(model)));
  }
}
