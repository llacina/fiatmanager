-- Table: currencies
-- DROP TABLE IF EXISTS currencies;

CREATE TABLE currencies (
  code VARCHAR(3) PRIMARY KEY,
  name TEXT NOT NULL
);

INSERT INTO currencies (code, name) VALUES
  ('CZK', 'Czech Koruna'),
  ('EUR', 'Euro'),
  ('USD', 'US Dollar');


COMMENT ON TABLE currencies
  IS 'List of Currencies';
