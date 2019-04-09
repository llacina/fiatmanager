
-- Table: exchange_record
-- DROP TABLE IF EXISTS addresses;

-- Create sequence
CREATE SEQUENCE sq_addresses_id;

-- Create table
CREATE TABLE addresses (
    id INTEGER PRIMARY KEY default nextval('sq_addresses_id'),
    channel_id INTEGER not null,
    bank_account_id  INTEGER not null,
    variable_symbol VARCHAR(10),
    constant_symbol VARCHAR(4),
    specific_symbol VARCHAR(10),
    created_at timestamp without time zone default now() not null,
    CONSTRAINT cn_bank_ident_currency_id UNIQUE (channel_id, bank_account_id, variable_symbol, constant_symbol, specific_symbol) -- channel_id, bank_account_id, combine variable_symbol, constant_symbol, specific_symbol, + currency_id is unique
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_addresses_id owned by addresses.id;

-- Add reference to channel
ALTER TABLE addresses ADD CONSTRAINT addresses_ref_channel_id_fkey FOREIGN KEY (channel_id) REFERENCES channels (id);
-- Add reference to account
ALTER TABLE addresses ADD CONSTRAINT addresses_ref_bank_account_id_fkey FOREIGN KEY (bank_account_id) REFERENCES bank_accounts (id);

COMMENT ON TABLE addresses
  IS 'Representation of pair criteria';
