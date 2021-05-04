package com.ecfproject.app.dataprovider.repository;

import com.ecfproject.app.dataprovider.entity.LegalPersonPartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LegalPersonPartnerEntityRepository
  extends JpaRepository<LegalPersonPartnerEntity, Long> {

  List<LegalPersonPartnerEntity> findByLegalPersonId(Long legalPersonId);

}
