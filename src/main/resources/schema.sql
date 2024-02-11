DROP TABLE IF EXISTS
    driver_number_coefficient,
    age_driving_experience_coefficient,
    kmb_coefficient,
    region,
    region_coefficient,
    engine_power_coefficient,
    base_rate_coefficient,
    new_insurance_request,
    insurance_companies,
    licenses,
    insurances,
    required_documents,
    features,
    validity_periods,
    new_consultation_request,
    season_coefficient,
    kasko_car_models,
    kasko_driving_experience_coefficient,
    kasko_manufacture_year_coefficient,
    dms_insurance
    CASCADE;


CREATE TABLE IF NOT EXISTS insurance_companies
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name        varchar(255) NOT NULL,
    description varchar(255),
    rating      NUMERIC(2, 1) CHECK (rating >= 0 AND rating <= 5),
    logo        varchar(255),
    coefficient NUMERIC      NOT NULL
);


CREATE TABLE IF NOT EXISTS licenses
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    company_id BIGINT        NOT NULL,
    license    varchar(1000) NOT NULL,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES insurance_companies (id)
);


CREATE TABLE IF NOT EXISTS insurances
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    company_id      BIGINT       NOT NULL,
    type            varchar(10)  NOT NULL,
    name            varchar(255) NOT NULL,
    description     varchar(255) NOT NULL,
    processing_time integer,
    CONSTRAINT fk_company_id FOREIGN KEY (company_id) REFERENCES insurance_companies (id)
);


CREATE TABLE IF NOT EXISTS required_documents
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    insurance_id BIGINT,
    document     varchar(255),
    UNIQUE (insurance_id, document),
    CONSTRAINT fk_insurance_id FOREIGN KEY (insurance_id) REFERENCES insurances (id)
);


CREATE TABLE IF NOT EXISTS features
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    insurance_id        BIGINT       NOT NULL,
    feature_name        varchar(255) NOT NULL,
    feature_description varchar(1000),
    UNIQUE (feature_name),
    CONSTRAINT fk_insurance_id FOREIGN KEY (insurance_id) REFERENCES insurances (id)
);


CREATE TABLE IF NOT EXISTS validity_periods
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    insurance_id    BIGINT,
    validity_period integer,
    UNIQUE (insurance_id, validity_period),
    CONSTRAINT fk_insurance_id FOREIGN KEY (insurance_id) REFERENCES insurances (id)
);


CREATE TABLE IF NOT EXISTS driver_number_coefficient
(
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    driver_number VARCHAR(100)  NOT NULL,
    coefficient   NUMERIC(3, 2) NOT NULL
);


CREATE TABLE IF NOT EXISTS age_driving_experience_coefficient
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    age_range                VARCHAR(10),
    driving_experience_range VARCHAR(10),
    coefficient              NUMERIC
);


CREATE TABLE IF NOT EXISTS kmb_coefficient
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    kbm         VARCHAR(10) NOT NULL,
    coefficient NUMERIC     NOT NULL
);


CREATE TABLE IF NOT EXISTS region
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    region VARCHAR(255) NOT NULL
);
COMMENT ON COLUMN region.region IS 'Наименование региона';


CREATE TABLE IF NOT EXISTS region_coefficient
(
    id                          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    region_id                   BIGINT REFERENCES region (id),
    region                      VARCHAR(255)  NOT NULL,
    vehicle_coefficient         NUMERIC(4, 2) NOT NULL,
    special_vehicle_coefficient NUMERIC(4, 2) NOT NULL
);
COMMENT ON COLUMN region_coefficient.region IS 'Регион преимущественного использования транспортного средства';
COMMENT ON COLUMN region_coefficient.vehicle_coefficient IS 'Территориальный коэффициент (КТ) для автомобильного транспорта и мотоциклов';
COMMENT ON COLUMN region_coefficient.special_vehicle_coefficient IS 'Территориальный коэффициент (КТ) для спецтехники';


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
    min_coefficient BIGINT       NOT NULL,
    max_coefficient BIGINT       NOT NULL
);


CREATE TABLE new_insurance_request
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    full_name    VARCHAR(256) NOT NULL,
    phone_number VARCHAR(12)  NOT NULL,
    email        VARCHAR(255) NOT NULL,
    situation    VARCHAR(500) NOT NULL,
    as_a_gift    BOOLEAN
);

CREATE TABLE IF NOT EXISTS new_consultation_request
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    first_name   VARCHAR(256) NOT NULL,
    last_name    VARCHAR(256) NOT NULL,
    phone_number VARCHAR(12)  NOT NULL,
    situation    VARCHAR(500) NOT NULL
);


CREATE TABLE IF NOT EXISTS season_coefficient
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    usage_period VARCHAR(10) NOT NULL,
    coefficient  NUMERIC     NOT NULL
);


CREATE TABLE IF NOT EXISTS kasko_car_models
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    brand       VARCHAR(255) NOT NULL,
    model       VARCHAR(255) NOT NULL,
    coefficient NUMERIC      NOT NULL
);

CREATE TABLE IF NOT EXISTS kasko_driving_experience_coefficient
(
    id                       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    driving_experience_range VARCHAR(10),
    coefficient              NUMERIC NOT NULL
);


CREATE TABLE IF NOT EXISTS kasko_manufacture_year_coefficient
(
    id               BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    manufacture_year INTEGER,
    coefficient      NUMERIC NOT NULL
);


CREATE TABLE IF NOT EXISTS dms_insurance
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    age            INT CHECK (age >= 0),
    insurance_term INT CHECK (insurance_term > 0),
    region         VARCHAR(255) NOT NULL,
    settlement     VARCHAR(255)
);