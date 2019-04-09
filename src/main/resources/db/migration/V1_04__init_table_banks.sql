-- Table: banks
-- DROP TABLE IF EXISTS banks;

-- Create sequence
CREATE SEQUENCE sq_banks_id;

CREATE TABLE banks (
  code VARCHAR(4) PRIMARY KEY,
  name TEXT NOT NULL,
  host TEXT NOT NULL,
  port TEXT NOT NULL,
  login TEXT NOT NULL,
  password TEXT NOT NULL
);

COMMENT ON TABLE banks
  IS 'List of Banks';

