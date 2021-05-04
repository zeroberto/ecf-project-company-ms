package com.ecfproject.app.dataprovider;

import com.ecfproject.app.dataprovider.mapper.LegalPersonPartnerMapper;
import com.ecfproject.app.dataprovider.repository.LegalPersonPartnerEntityRepository;
import com.ecfproject.core.dataprovider.LegalPersonPartnerDataProvider;
import com.ecfproject.core.model.LegalPersonPartner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Repository
@RequiredArgsConstructor
public class LegalPersonPartnerDataProviderSql implements LegalPersonPartnerDataProvider {

  private final LegalPersonPartnerEntityRepository repository;
  private final LegalPersonPartnerMapper mapper;

  @Override
  public Set<LegalPersonPartner> findAll() {
    return repository
      .findAll()
      .parallelStream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Optional<LegalPersonPartner> findById(final Long id) {
    return repository
      .findById(id)
      .map(mapper::entityToModel);
  }

  @Override
  public LegalPersonPartner save(final LegalPersonPartner model) {
    return mapper.entityToModel(repository.save(
      mapper.modelToEntity(model)));
  }

  @Override
  public Set<LegalPersonPartner> findAllByLegalPersonId(final Long legalPersonId) {
    return repository
      .findByLegalPersonId(legalPersonId)
      .stream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }

  @Override
  public Set<LegalPersonPartner> saveAll(final Set<LegalPersonPartner> legalPersonPartners) {
    return repository
      .saveAll(
        legalPersonPartners
          .stream()
          .map(mapper::modelToEntity)
          .collect(Collectors.toSet()))
      .stream()
      .map(mapper::entityToModel)
      .collect(toSet());
  }
}
