-- Table: bank_accounts
-- DROP TABLE IF EXISTS bank_accounts;

-- Create sequence
CREATE SEQUENCE sq_bank_accounts_id;

CREATE TABLE bank_accounts (
  id INTEGER PRIMARY KEY default nextval('sq_bank_accounts_id'),
  bank_code VARCHAR(4) not null UNIQUE,
  name TEXT NOT NULL,
  prefix VARCHAR(6),
  account_number VARCHAR(10) not null,
  iban VARCHAR(24),
  currency_code VARCHAR(3) not null
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_bank_accounts_id owned by bank_accounts.id;

-- Add reference to currencies
ALTER TABLE bank_accounts ADD CONSTRAINT bank_accounts_ref_currency_code_fkey FOREIGN KEY (currency_code) REFERENCES currencies (code);
-- Add reference to banks
ALTER TABLE bank_accounts ADD CONSTRAINT bank_accounts_ref_bank_code_fkey FOREIGN KEY (bank_code) REFERENCES banks (code);

COMMENT ON TABLE bank_accounts
  IS 'List of Bank accounts for synchronize';
