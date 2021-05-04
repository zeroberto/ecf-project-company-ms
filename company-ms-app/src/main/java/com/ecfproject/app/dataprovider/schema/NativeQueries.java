package com.ecfproject.app.dataprovider.schema;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class NativeQueries {

  public static final String FIND_ADDRESS_BY_LEGAL_PERSON_ID = """
    SELECT
      a.*
    FROM
      address a
      INNER JOIN
        legal_person_address lpa
        ON lpa.address_id = a.id
    WHERE
      lpa.natural_person_id = ?
    """;

  public static final String FIND_ADDRESS_BY_NATURAL_PERSON_ID = """
    SELECT
      a.*
    FROM
      address a
      INNER JOIN
        natural_person_address npa
        ON npa.address_id = a.id
    WHERE
      npa.natural_person_id = ?
    """;

  public static final String FIND_CONTACT_BY_LEGAL_PERSON_ID = """
    SELECT
      c.*
    FROM
      contact c
      INNER JOIN
        legal_person_contact lpc
        ON lpc.contact_id = c.id
    WHERE
      lpc.natural_person_id = ?
    """;

  public static final String FIND_CONTACT_BY_NATURAL_PERSON_ID = """
    SELECT
      c.*
    FROM
      contact c
      INNER JOIN
        natural_person_contact npc
        ON npc.contact_id = c.id
    WHERE
      npc.natural_person_id = ?
    """;

}
