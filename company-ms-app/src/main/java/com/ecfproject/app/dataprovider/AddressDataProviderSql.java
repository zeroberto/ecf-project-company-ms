package com.ecfproject.app.dataprovider;

import com.ecfproject.app.dataprovider.mapper.AddressMapper;
import com.ecfproject.app.dataprovider.repository.AddressEntityRepository;
import com.ecfproject.core.dataprovider.AddressDataProvider;
import com.ecfproject.core.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class AddressDataProviderSql implements AddressDataProvider {

  private final AddressEntityRepository repository;
  private final AddressMapper mapper;

  @Override
  public Set<Address> findAll() {
    return repository
      .findAll()
      .parallelStream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Optional<Address> findById(final Long id) {
    return repository
      .findById(id)
      .map(mapper::entityToModel);
  }

  @Override
  public Address save(final Address model) {
    return mapper.entityToModel(
      repository.save(mapper.modelToEntity(model)));
  }

  @Override
  public Optional<Address> findByLegalPersonId(final Long legalPersonId) {
    return repository
      .findByLegalPersonId(legalPersonId)
      .stream()
      .findFirst()
      .map(mapper::entityToModel);
  }

  @Override
  public Optional<Address> findByNaturalPersonId(final Long naturalPersonId) {
    return repository
      .findByNaturalPersonId(naturalPersonId)
      .stream()
      .findFirst()
      .map(mapper::entityToModel);
  }
}
