CREATE DATABASE events;

CREATE SCHEMA afisha
    AUTHORIZATION postgres;

CREATE TABLE afisha.events
(
    uuid uuid NOT NULL,
    author text NOT NULL,
    dt_create time(3) without time zone NOT NULL,
    dt_update time(3) without time zone NOT NULL,
    title text NOT NULL,
    description text NOT NULL,
    dt_event bigint NOT NULL,
    dt_end_of_sale bigint NOT NULL,
    type text NOT NULL,
    status text NOT NULL,
    PRIMARY KEY (uuid)
);

ALTER TABLE IF EXISTS afisha.events
    OWNER to postgres;

CREATE TABLE afisha.concert
(
    category uuid NOT NULL,
    uuid_concert uuid NOT NULL,
    PRIMARY KEY (uuid_concert),
    CONSTRAINT f_key FOREIGN KEY (uuid_concert)
        REFERENCES afisha.events (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS afisha.concert
    OWNER to postgres;


CREATE TABLE afisha.films
(
    country uuid NOT NULL,
    duration integer NOT NULL,
    release_date bigint NOT NULL,
    release_year bigint NOT NULL,
    uuid_film uuid NOT NULL,
    PRIMARY KEY (uuid_film),
    CONSTRAINT f_key_film FOREIGN KEY (uuid_film)
        REFERENCES afisha.events (uuid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE IF EXISTS afisha.films
    OWNER to postgres;
