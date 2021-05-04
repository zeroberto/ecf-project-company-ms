package com.ecfproject.app.dataprovider.schema;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Schema {

  public static final String ADDRESS_TABLE_NAME = "address";
  public static final String CONTACT_TABLE_NAME = "contact";
  public static final String LEGAL_PERSON_TABLE_NAME = "legal_person";
  public static final String LEGAL_PERSON_PARTNER_TABLE_NAME = "legal_person_partner";
  public static final String NATURAL_PERSON_TABLE_NAME = "natural_person";

  @UtilityClass
  public static final class LegalPersonColumn {
    public static final String TRADING_NAME_COLUMN_NAME = "trading_name";
    public static final String OPENING_DATE_COLUMN_NAME = "opening_date";
  }

  @UtilityClass
  public static final class NaturalPersonColumn {
    public static final String BIRTH_DATE_COLUMN_NAME = "birth_date";
  }

  @UtilityClass
  public static final class CommonColumn {
    public static final String CREATED_AT_COLUMN_NAME = "created_at";
    public static final String LEGAL_PERSON_ID_COLUMN_NAME = "legal_person_id";
    public static final String NATURAL_PERSON_ID_COLUMN_NAME = "natural_person_id";
    public static final String UPDATED_AT_COLUMN_NAME = "updated_at";
  }
}
