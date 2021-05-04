package com.ecfproject.app.dataprovider.repository;

import com.ecfproject.app.dataprovider.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static com.ecfproject.app.dataprovider.schema.NativeQueries.FIND_CONTACT_BY_LEGAL_PERSON_ID;
import static com.ecfproject.app.dataprovider.schema.NativeQueries.FIND_CONTACT_BY_NATURAL_PERSON_ID;

public interface ContactEntityRepository extends JpaRepository<ContactEntity, Long> {

  @Query(value = FIND_CONTACT_BY_LEGAL_PERSON_ID, nativeQuery = true)
  List<ContactEntity> findByLegalPersonId(Long naturalPersonId);

  @Query(value = FIND_CONTACT_BY_NATURAL_PERSON_ID, nativeQuery = true)
  List<ContactEntity> findByNaturalPersonId(Long naturalPersonId);

}
