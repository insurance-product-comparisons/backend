DROP TABLE IF EXISTS driver_number_coefficient,
    age,
    driving_experience,
    age_experience_coefficient,
    kmb_coefficient,
    region_coefficient,
    engine_power_coefficient,
    base_rate_coefficient,
    new_insurance_request
    CASCADE;


CREATE TABLE IF NOT EXISTS driver_number_coefficient
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    driver_number VARCHAR(100)  NOT NULL,
    coefficient   NUMERIC(3, 2) NOT NULL
);


CREATE TABLE IF NOT EXISTS age
(
    id  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    age VARCHAR(20) NOT NULL
);


CREATE TABLE IF NOT EXISTS driving_experience
(
    id                 BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    driving_experience VARCHAR(20) NOT NULL
);


CREATE TABLE IF NOT EXISTS age_experience_coefficient
(
    age_id        BIGINT  NOT NULL,
    experience_id BIGINT  NOT NULL,
    coefficient   NUMERIC NOT NULL,

    CONSTRAINT fk_age_id
        FOREIGN KEY (age_id) REFERENCES age (id),
    CONSTRAINT fk_experience_id
        FOREIGN KEY (experience_id) REFERENCES driving_experience (id),
    PRIMARY KEY (age_id, experience_id)
);


CREATE TABLE IF NOT EXISTS kmb_coefficient
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    kbm         VARCHAR(10) NOT NULL,
    coefficient NUMERIC     NOT NULL
);

DROP TABLE IF EXISTS region CASCADE;
CREATE TABLE IF NOT EXISTS region
(
    id   BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
COMMENT ON COLUMN region.name IS 'Наименование региона';

DROP TABLE IF EXISTS region_coefficient CASCADE;
CREATE TABLE IF NOT EXISTS region_coefficient
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    region_id           BIGINT REFERENCES region (id),
    name                VARCHAR(255)  NOT NULL,
    coefficient_exclude NUMERIC(5, 3) NOT NULL,
    coefficient_include NUMERIC(5, 3) NOT NULL
);
COMMENT ON COLUMN region_coefficient.name IS 'Территория преимущественного использования транспортного средства';
COMMENT ON COLUMN region_coefficient.coefficient_exclude IS 'Коэффициент КТ для транспортных средств, за исключением Тракторы, самоходные дорожно-строительные';
COMMENT ON COLUMN region_coefficient.coefficient_include IS 'Коэффициент КТ для Тракторы, самоходные дорожно-строительные';


CREATE TABLE IF NOT EXISTS engine_power_coefficient
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    engine_power VARCHAR(20) NOT NULL,
    coefficient  NUMERIC     NOT NULL
);


CREATE TABLE IF NOT EXISTS base_rate_coefficient
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    transport_type  VARCHAR(255) NOT NULL,
    min_coefficient INTEGER      NOT NULL,
    max_coefficient INTEGER      NOT NULL
);


CREATE TABLE new_insurance_request
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name    VARCHAR(256)  NOT NULL,
    phone_number VARCHAR(12)  NOT NULL,
    email        VARCHAR(255) NOT NULL,
    situation    VARCHAR(500) NOT NULL,
    as_a_gift    BOOLEAN
);