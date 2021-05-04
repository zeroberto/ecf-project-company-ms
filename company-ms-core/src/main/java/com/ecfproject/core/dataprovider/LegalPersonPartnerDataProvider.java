package com.ecfproject.core.dataprovider;

import com.ecfproject.core.model.LegalPersonPartner;

import java.util.Set;

public interface LegalPersonPartnerDataProvider extends GenericDataProvider<LegalPersonPartner> {

  Set<LegalPersonPartner> findAllByLegalPersonId(Long legalPersonId);

  Set<LegalPersonPartner> saveAll(Set<LegalPersonPartner> legalPersonPartners);

}
