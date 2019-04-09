-- Table: banks
-- DROP TABLE IF EXISTS banks;

-- Create sequence
CREATE SEQUENCE sq_banks_id;

CREATE TABLE banks (
  id INTEGER PRIMARY KEY default nextval('sq_banks_id'),
  code VARCHAR(4) NOT NULL,
  name TEXT NOT NULL,
  host TEXT NOT NULL,
  port TEXT NOT NULL,
  login TEXT NOT NULL,
  password TEXT NOT NULL
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_banks_id owned by banks.id;
