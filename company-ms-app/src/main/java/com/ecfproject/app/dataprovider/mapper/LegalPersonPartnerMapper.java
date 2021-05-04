package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.LegalPersonPartnerEntity;
import com.ecfproject.core.model.LegalPersonPartner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LegalPersonPartnerMapper {

  @Mapping(target = "naturalPerson.id", source = "naturalPersonId")
  LegalPersonPartner entityToModel(LegalPersonPartnerEntity entity);

  @Mapping(target = "naturalPersonId", source = "naturalPerson.id")
  LegalPersonPartnerEntity modelToEntity(LegalPersonPartner model);

}
