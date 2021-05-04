package com.ecfproject.app.dataprovider.mapper;

import com.ecfproject.app.dataprovider.entity.ContactEntity;
import com.ecfproject.core.model.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

  Contact entityToModel(ContactEntity entity);

  ContactEntity modelToEntity(Contact model);

}
