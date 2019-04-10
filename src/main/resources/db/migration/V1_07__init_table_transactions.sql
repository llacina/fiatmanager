
-- Table: exchange_record
-- DROP TABLE IF EXISTS transactions;

-- Create sequence
CREATE SEQUENCE sq_transactions_id;


-- Create table
CREATE TABLE transactions (
    id INTEGER PRIMARY KEY default nextval('sq_transactions_id'),
    txid TEXT not null,               -- The TXID of the transaction
    bank_account_id INTEGER not null,
    amount numeric(18,8) not null,
    prefix VARCHAR(6),
    account_number VARCHAR(10) not null,
    bank_code VARCHAR(4) not null,
    iban VARCHAR(24),
    variable_symbol VARCHAR(10),
    constant_symbol VARCHAR(4),
    specific_symbol VARCHAR(10),
    type VARCHAR(10) not null,
    payer_message TEXT,                                -- Message for payer. Empty for incoming transactions
    payee_message TEXT,                                -- Message for payee (e.g. for client receiving transaction
    value_at timestamp without time zone not null,     -- Transaction value date, e.g. the day transaction \"happened\"
    booking_at timestamp without time zone not null,   -- Transaction booking date, e.g. the day transaction was bookkeeped
    note TEXT,                                         -- Note for user (of fiatmanager)
    status character varying(10) not null,
    created_at timestamp without time zone default now() not null,
    CONSTRAINT cn_txid_bank_account_id UNIQUE (txid, bank_account_id) -- txid, bank_account_id is unique
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_transactions_id owned by transactions.id;

-- Add reference to bank_account
ALTER TABLE transactions ADD CONSTRAINT transactions_ref_bank_account_id_fkey FOREIGN KEY (bank_account_id) REFERENCES bank_accounts (id);

COMMENT ON TABLE transactions
  IS 'Representation of fiat transactions';
