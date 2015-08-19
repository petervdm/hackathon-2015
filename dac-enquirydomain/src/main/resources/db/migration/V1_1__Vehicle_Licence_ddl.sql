CREATE SEQUENCE seq_licenceid
    START WITH 100
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999999999999
    CACHE 1;

SET default_with_oids = false;

CREATE TABLE licence (
    validfromdate date,
    validtodate date,
    licenceperiod integer,
    amountpaid real,
    licencestatus integer,
    isadvanced character varying,
    extraweeks integer,
    taxclass character varying(2),
    isoffroad character varying,
    vehicleid bigint,
    licenceid bigint DEFAULT nextval('seq_licenceid'::regclass) NOT NULL,
    issuedatetime timestamp without time zone
);
COMMENT ON TABLE licence IS 'Contains details of vehicle licenses';
COMMENT ON COLUMN licence.validfromdate IS 'Date that the license is valid from ';
COMMENT ON COLUMN licence.validtodate IS 'date that the license is valid to';
COMMENT ON COLUMN licence.licenceperiod IS 'The period of the licence - usually 6 or 12 months';
COMMENT ON COLUMN licence.amountpaid IS 'the amount that was paid for the license';
COMMENT ON COLUMN licence.licencestatus IS 'Licenced or Unlicenced';
COMMENT ON COLUMN licence.isadvanced IS 'Whether the licence is for the current month or commencing in the next month.';
COMMENT ON COLUMN licence.extraweeks IS 'number of weeks prior to the end of the month that the license should commence from ';
COMMENT ON COLUMN licence.isoffroad IS 'whether this license is on road or off road - used to be called "SORN"';
COMMENT ON COLUMN licence.vehicleid IS 'vehicle identifier';
COMMENT ON COLUMN licence.licenceid IS 'vehicle licence identifier';

CREATE TABLE licencestatus (
    licenceid bigint NOT NULL,
    licencestatus smallint,
    eventid bigint
);
COMMENT ON TABLE licencestatus IS 'licence statuses';
COMMENT ON COLUMN licencestatus.licenceid IS 'primary key of licence';
COMMENT ON COLUMN licencestatus.licencestatus IS 'licence status';
COMMENT ON COLUMN licencestatus.eventid IS 'event identifier';

CREATE TABLE licencestatushistory (
    vehicleid bigint,
    statusid bigint,
    statushistoryid bigint,
    "timestamp" timestamp with time zone[],
    event character varying(30)
);
COMMENT ON TABLE licencestatushistory IS 'licence status history';
COMMENT ON COLUMN licencestatushistory.statushistoryid IS 'licence status hisroty';

ALTER TABLE ONLY licencestatus
    ADD CONSTRAINT licenceid PRIMARY KEY (licenceid);

ALTER TABLE ONLY licence
    ADD CONSTRAINT licenceidprimaryconstraint PRIMARY KEY (licenceid);
