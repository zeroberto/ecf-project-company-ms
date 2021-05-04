package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.AddressEntity;
import com.ecfproject.core.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

  Address entityToModel(AddressEntity entity);

  AddressEntity modelToEntity(Address model);

}
