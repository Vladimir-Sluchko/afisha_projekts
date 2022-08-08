CREATE DATABASE classifier;

GRANT ALL PRIVILEGES ON DATABASE postgres TO postgres;

\connect classifier;

CREATE SCHEMA library
    AUTHORIZATION postgres;

CREATE TABLE library.category
(
    uuid uuid NOT NULL,
    title text NOT NULL,
    dt_create timestamp(3) without time zone NOT NULL,
    dt_update timestamp(3) without time zone NOT NULL,
    PRIMARY KEY (uuid)
)
    TABLESPACE pg_default;

CREATE TABLE library.country
(
    uuid uuid NOT NULL,
    title text NOT NULL,
    description text NOT NULL,
    dt_update timestamp(3) without time zone NOT NULL,
    dt_create timestamp(3) without time zone NOT NULL,
    PRIMARY KEY (uuid)
)
    TABLESPACE pg_default;

ALTER TABLE IF EXISTS library.country
    OWNER to postgres;

ALTER TABLE IF EXISTS library.category
    OWNER to postgres;