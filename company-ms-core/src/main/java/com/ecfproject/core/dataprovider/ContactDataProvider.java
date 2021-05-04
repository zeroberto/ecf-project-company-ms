package com.ecfproject.core.dataprovider;

import com.ecfproject.core.model.Contact;

import java.util.Optional;

public interface ContactDataProvider extends GenericDataProvider<Contact> {

  Optional<Contact> findByLegalPersonId(Long legalPersonId);

  Optional<Contact> findByNaturalPersonId(Long naturalPersonId);

}
