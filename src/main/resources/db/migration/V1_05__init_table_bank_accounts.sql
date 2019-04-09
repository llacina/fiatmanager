-- Table: bank_accounts
-- DROP TABLE IF EXISTS bank_accounts;

-- Create sequence
CREATE SEQUENCE sq_bank_accounts_id;

CREATE TABLE bank_accounts (
  id INTEGER PRIMARY KEY default nextval('sq_bank_accounts_id'),
  banks_id INTEGER not null,
  name TEXT NOT NULL,
  prefix VARCHAR(6),
  account_number VARCHAR(10) not null,
  bank_code VARCHAR(4) not null,
  iban VARCHAR(24),
  variable_symbol VARCHAR(10),
  constant_symbol VARCHAR(4),
  specific_symbol VARCHAR(10),
  currency_code VARCHAR(3) not null
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_bank_accounts_id owned by bank_accounts.id;

-- Add reference to currencies
ALTER TABLE bank_accounts ADD CONSTRAINT bank_accounts_ref_currency_code_fkey FOREIGN KEY (currency_code) REFERENCES currencies (code);
-- Add reference to banks
ALTER TABLE bank_accounts ADD CONSTRAINT bank_accounts_ref_banks_id_fkey FOREIGN KEY (banks_id) REFERENCES banks (id);

COMMENT ON TABLE currencies
  IS 'List of Wallets';
