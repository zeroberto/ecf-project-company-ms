package com.ecfproject.app.dataprovider.repository;

import com.ecfproject.app.dataprovider.entity.AddressEntity;
import com.ecfproject.app.dataprovider.schema.NativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressEntityRepository extends JpaRepository<AddressEntity, Long> {

  @Query(value = NativeQueries.FIND_ADDRESS_BY_LEGAL_PERSON_ID, nativeQuery = true)
  List<AddressEntity> findByLegalPersonId(Long naturalPersonId);

  @Query(value = NativeQueries.FIND_ADDRESS_BY_NATURAL_PERSON_ID, nativeQuery = true)
  List<AddressEntity> findByNaturalPersonId(Long naturalPersonId);

}
