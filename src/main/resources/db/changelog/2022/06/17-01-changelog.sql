-- liquibase formatted sql

-- changeset Sergey:1655469393380-1
CREATE TABLE json_data
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    uuid      UUID NOT NULL,
    json_data CLOB,
    CONSTRAINT pk_json_data PRIMARY KEY (id)
);

-- changeset Sergey:1655469393380-2
ALTER TABLE json_data
    ADD CONSTRAINT uc_json_data_uuid UNIQUE (uuid);

