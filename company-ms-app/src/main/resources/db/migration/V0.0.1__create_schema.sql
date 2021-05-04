CREATE TABLE IF NOT EXISTS natural_person
(
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  document VARCHAR(11) NOT NULL,
  birth_date date NOT NULL,
  gender VARCHAR(40) NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS legal_person
(
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  trading_name VARCHAR(200) NOT NULL,
  document VARCHAR(14) NOT NULL,
  type VARCHAR(100) NOT NULL,
  opening_date date NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS address
(
  id BIGSERIAL PRIMARY KEY,
  street VARCHAR(120) NOT NULL,
  number VARCHAR(20) NOT NULL,
  complement VARCHAR(120) NOT NULL,
  neighborhood VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  state VARCHAR(100) NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE IF NOT EXISTS natural_person_address
(
  id BIGSERIAL PRIMARY KEY,
  natural_person_id BIGINT NOT NULL,
  address_id BIGINT NOT NULL,
  CONSTRAINT fk_columns
    FOREIGN KEY(natural_person_id)
      REFERENCES natural_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(address_id)
      REFERENCES address(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS legal_person_address
(
  id BIGSERIAL PRIMARY KEY,
  legal_person_id BIGINT NOT NULL,
  address_id BIGINT NOT NULL,
  CONSTRAINT fk_columns
    FOREIGN KEY(legal_person_id)
      REFERENCES legal_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(address_id)
      REFERENCES address(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS contact
(
  id BIGSERIAL PRIMARY KEY,
  type VARCHAR(50) NOT NULL,
  value VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS natural_person_contact
(
  id BIGSERIAL PRIMARY KEY,
  natural_person_id BIGINT NOT NULL,
  contact_id BIGINT NOT NULL,
  CONSTRAINT fk_columns
    FOREIGN KEY(natural_person_id)
      REFERENCES natural_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(contact_id)
      REFERENCES contact(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS legal_person_contact
(
  id BIGSERIAL PRIMARY KEY,
  legal_person_id BIGINT NOT NULL,
  contact_id BIGINT NOT NULL,
  CONSTRAINT fk_columns
    FOREIGN KEY(legal_person_id)
      REFERENCES legal_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(contact_id)
      REFERENCES contact(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS legal_person_partner
(
  id BIGSERIAL PRIMARY KEY,
  natural_person_id BIGINT NOT NULL,
  legal_person_id BIGINT NOT NULL,
  type VARCHAR(20) NOT NULL,
  CONSTRAINT fk_columns
    FOREIGN KEY(natural_person_id)
      REFERENCES natural_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY(legal_person_id)
      REFERENCES legal_person(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
