package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.LegalPersonEntity;
import com.ecfproject.core.model.LegalPerson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LegalPersonMapper {

  @Mapping(target = "address", ignore = true)
  @Mapping(target = "contact", ignore = true)
  @Mapping(target = "partners", ignore = true)
  LegalPerson entityToModel(LegalPersonEntity entity);

  LegalPersonEntity modelToEntity(LegalPerson model);

}
