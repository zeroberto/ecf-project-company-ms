package com.ecfproject.app.dataprovider;

import com.ecfproject.app.dataprovider.mapper.ContactMapper;
import com.ecfproject.app.dataprovider.repository.ContactEntityRepository;
import com.ecfproject.core.dataprovider.ContactDataProvider;
import com.ecfproject.core.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class ContactDataProviderSql implements ContactDataProvider {

  private final ContactEntityRepository repository;
  private final ContactMapper mapper;

  @Override
  public Set<Contact> findAll() {
    return repository
      .findAll()
      .parallelStream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Optional<Contact> findById(final Long id) {
    return repository
      .findById(id)
      .map(mapper::entityToModel);
  }

  @Override
  public Contact save(final Contact model) {
    return mapper.entityToModel(
      repository.save(mapper.modelToEntity(model)));
  }

  @Override
  public Optional<Contact> findByLegalPersonId(final Long legalPersonId) {
    return repository
      .findByLegalPersonId(legalPersonId)
      .stream()
      .findFirst()
      .map(mapper::entityToModel);
  }

  @Override
  public Optional<Contact> findByNaturalPersonId(final Long naturalPersonId) {
    return repository
      .findByNaturalPersonId(naturalPersonId)
      .stream()
      .findFirst()
      .map(mapper::entityToModel);
  }
}
