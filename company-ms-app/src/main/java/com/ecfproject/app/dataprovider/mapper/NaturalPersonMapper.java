package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.NaturalPersonEntity;
import com.ecfproject.core.model.NaturalPerson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NaturalPersonMapper {

  @Mapping(target = "address", ignore = true)
  @Mapping(target = "contact", ignore = true)
  NaturalPerson entityToModel(NaturalPersonEntity entity);

  NaturalPersonEntity modelToEntity(NaturalPerson model);

}
