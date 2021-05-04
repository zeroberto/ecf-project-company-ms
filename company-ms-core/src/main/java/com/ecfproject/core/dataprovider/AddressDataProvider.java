package com.ecfproject.core.dataprovider;

import com.ecfproject.core.model.Address;

import java.util.Optional;

public interface AddressDataProvider extends GenericDataProvider<Address> {

  Optional<Address> findByLegalPersonId(Long legalPersonId);

  Optional<Address> findByNaturalPersonId(Long naturalPersonId);

}
