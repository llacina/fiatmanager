-- Table: fees
-- DROP TABLE IF EXISTS fees;

-- Create sequence
CREATE SEQUENCE sq_fees_id;

CREATE TABLE fees (
  id INTEGER PRIMARY KEY default nextval('sq_fees_id'),
  transactions_id INTEGER,
  type VARCHAR(10),
  amount numeric(18,8) not null
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_fees_id owned by fees.id;

-- Add reference to transaction
ALTER TABLE fees ADD CONSTRAINT fees_ref_transactions_id_fkey FOREIGN KEY (transactions_id) REFERENCES transactions (id);
