
-- Table: channels
-- DROP TABLE IF EXISTS channels;

-- Create sequence
CREATE SEQUENCE sq_channels_id;


-- Create table
CREATE TABLE channels (
  id INTEGER PRIMARY KEY default nextval('sq_channels_id'),
  code character varying(10) NOT NULL UNIQUE,               -- code
  name text NOT NULL,                                       -- name of channel
  created_at timestamp without time zone default now() not null,
	CONSTRAINT cn_channel_code UNIQUE (code)                -- code is unique
);

-- Sequence to be associated with a specific table column
ALTER SEQUENCE sq_channels_id owned by channels.id;

COMMENT ON TABLE channels
  IS 'Representation of channel';
