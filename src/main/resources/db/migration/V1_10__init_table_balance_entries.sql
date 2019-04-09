-- Table: balance_entries
-- DROP TABLE IF EXISTS balance_entries;

-- Create sequence
CREATE SEQUENCE sq_balance_entries_id;

-- Create table
CREATE TABLE balance_entries (
    id INTEGER PRIMARY KEY default nextval('sq_balance_entries_id'),
    channel_id INTEGER not null,
    currency_code VARCHAR(3) not null,
    request_id INTEGER not null,
    transaction_id INTEGER,
    amount numeric(18,8) not null,
    status character varying(10) not null,
    created_at timestamp without time zone default now() not null
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_balance_entries_id owned by balance_entries.id;

-- Add reference to channel
ALTER TABLE balance_entries ADD CONSTRAINT balance_entries_ref_channel_id_fkey FOREIGN KEY (channel_id) REFERENCES channels (id);
-- Add reference to currencies
ALTER TABLE balance_entries ADD CONSTRAINT balance_entries_ref_currency_code_fkey FOREIGN KEY (currency_code) REFERENCES currencies (code);
-- Add reference to requests
ALTER TABLE balance_entries ADD CONSTRAINT balance_entries_ref_request_id_fkey FOREIGN KEY (request_id) REFERENCES requests (id);
-- Add reference to transactions
ALTER TABLE balance_entries ADD CONSTRAINT balance_entries_ref_transactions_id_fkey FOREIGN KEY (transaction_id) REFERENCES transactions (id);

COMMENT ON TABLE balance_entries
  IS 'Representation of balance item';
