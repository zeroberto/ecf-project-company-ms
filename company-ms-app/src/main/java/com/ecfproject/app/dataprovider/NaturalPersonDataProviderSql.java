package com.ecfproject.app.dataprovider;

import com.ecfproject.app.dataprovider.mapper.NaturalPersonMapper;
import com.ecfproject.app.dataprovider.repository.NaturalPersonEntityRepository;
import com.ecfproject.core.dataprovider.NaturalPersonDataProvider;
import com.ecfproject.core.model.NaturalPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class NaturalPersonDataProviderSql implements NaturalPersonDataProvider {

  private final NaturalPersonEntityRepository repository;
  private final NaturalPersonMapper mapper;

  @Override
  public Set<NaturalPerson> findAll() {
    return repository
      .findAll()
      .stream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Optional<NaturalPerson> findById(final Long id) {
    return repository
      .findById(id)
      .map(mapper::entityToModel);
  }

  @Transactional
  @Override
  public NaturalPerson save(final NaturalPerson model) {
    return mapper.entityToModel(
      repository.save(mapper.modelToEntity(model)));
  }
}
