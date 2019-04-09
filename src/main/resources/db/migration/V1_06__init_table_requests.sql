-- Table: request
-- DROP TABLE IF EXISTS requests;

-- Create sequence
CREATE SEQUENCE sq_requests_id;

-- Create table
CREATE TABLE requests (
    id bigint PRIMARY KEY default nextval('sq_requests_id'),
    external_id UUID NOT null unique,                            -- external identification of request
    request JSONB,                                      -- request in json
    created_at timestamp without time zone default now() not null
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_requests_id owned by requests.id;

-- Add comment
COMMENT ON TABLE requests
  IS 'Representation of input request';
