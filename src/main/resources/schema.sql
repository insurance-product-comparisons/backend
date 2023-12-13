


--CREATE TABLE IF NOT EXISTS addresses
--(
--    id               BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    country          varchar(50) NOT NULL,
--    region           varchar(50) NOT NULL,
--    city             varchar(50) NOT NULL,
--    street           varchar(100),
--    house_number     varchar(10),
--    apartment_number varchar(10),
--    postal_code      varchar(10),
--    UNIQUE (region,
--            city,
--            street,
--            house_number,
--            apartment_number)
--);
--
--
--CREATE TABLE IF NOT EXISTS application_for_individual_insurances
--(
--    id                       BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    phone_number             varchar(15)   NOT NULL,
--    email                    varchar(255)  NOT NULL,
--    first_name               varchar(50)   NOT NULL,
--    last_name                varchar(50)   NOT NULL,
--    middle_name              varchar(50),
--    description_of_situation varchar(1000) NOT NULL,
--    policy_holder            varchar(50)   NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS company_news
--(
--    id         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    title      varchar(255)                        NOT NULL,
--    text       varchar                             NOT NULL,
--    created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS consultations_for_unregistered_users
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    first_name        varchar(50)                         NOT NULL,
--    last_name         varchar(50)                         NOT NULL,
--    phone_number      varchar(15)                         NOT NULL,
--    situation         varchar(255)                        NOT NULL,
--    created           timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
--    status            varchar(10)                         NOT NULL,
--    consultation_time timestamp WITH TIME ZONE
--);
--
--
--CREATE TABLE IF NOT EXISTS contact_types
--(
--    id            BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    contact_name  varchar(50)  NOT NULL,
--    contact_value varchar(255) NOT NULL UNIQUE
--);
--
--
--CREATE TABLE IF NOT EXISTS creators_of_project
--(
--    id          BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    first_name  varchar(50)  NOT NULL,
--    last_name   varchar(50)  NOT NULL,
--    role        varchar(255) NOT NULL,
--    description varchar(1000)
--);
--
--
--CREATE TABLE IF NOT EXISTS driving_license_categories
--(
--    id       BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    category varchar(10) NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS entity_types
--(
--    id          BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    entity_type varchar(50) NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS faqs
--(
--    id       BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    question varchar NOT NULL,
--    answer   varchar NOT NULL,
--    tags     varchar(255)
--);
--
--
--CREATE TABLE IF NOT EXISTS insurance_durations
--(
--    id                 BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    insurance_duration integer NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS licenses
--(
--    id            BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    license       varchar(1000) NOT NULL,
--    received_date date
--);
--
--
--CREATE TABLE IF NOT EXISTS news_writers
--(
--    id         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    first_name varchar(50) NOT NULL,
--    last_name  varchar(50) NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS types_of_insurance
--(
--    id   BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    TYPE varchar(255) NOT NULL
--);
--
--
--CREATE TABLE IF NOT EXISTS company_contacts
--(
--    id               BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    address_id       BIGINT,
--    contact_types_id BIGINT,
--    CONSTRAINT fk_address_id
--        FOREIGN KEY (address_id) REFERENCES addresses (id),
--    CONSTRAINT fk_contact_types_id
--        FOREIGN KEY (contact_types_id) REFERENCES contact_types (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS about_project
--(
--    id          BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    contact_id  BIGINT  NOT NULL,
--    creator_id  BIGINT  NOT NULL,
--    description varchar NOT NULL,
--    CONSTRAINT fk_contact_id
--        FOREIGN KEY (contact_id) REFERENCES company_contacts (id),
--    CONSTRAINT fk_creator_id
--        FOREIGN KEY (creator_id) REFERENCES creators_of_project (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS collaborations
--(
--    id                 BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    company_contact_id BIGINT                              NOT NULL,
--    company_name       varchar(100)                        NOT NULL,
--    inn                char(10)                            NOT NULL UNIQUE,
--    ogrn               char(13)                            NOT NULL UNIQUE,
--    type_of_insurance  varchar(255),
--    special_offer      varchar(1000),
--    strategic_goals    varchar(1000),
--    message            varchar(1000)                       NOT NULL,
--    created            timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
--    status             varchar(10)                         NOT NULL,
--    CONSTRAINT fk_company_contact_id
--        FOREIGN KEY (company_contact_id) REFERENCES company_contacts (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS companies
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    type_id           BIGINT        NOT NULL,
--    contact_id        BIGINT        NOT NULL,
--    address_id        BIGINT,
--    license_id        BIGINT        NOT NULL,
--    company_name      varchar(100)  NOT NULL,
--    foundation_date   date,
--    rating            numeric(2, 1) NOT NULL CHECK (rating <= 5.0),
--    number_of_clients integer,
--    CONSTRAINT fk_type_id
--        FOREIGN KEY (type_id) REFERENCES types_of_insurance (id),
--    CONSTRAINT fk_contact_id
--        FOREIGN KEY (contact_id) REFERENCES company_contacts (id),
--    CONSTRAINT fk_address_id
--        FOREIGN KEY (address_id) REFERENCES addresses (id),
--    CONSTRAINT fk_license_id
--        FOREIGN KEY (license_id) REFERENCES licenses (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS driver_licenses
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    place_of_birth_id BIGINT       NOT NULL,
--    category_id       integer      NOT NULL,
--    license_number    varchar(50)  NOT NULL,
--    date_of_issue     date         NOT NULL,
--    date_of_expiry    date         NOT NULL,
--    issuing_authority varchar(255) NOT NULL,
--    first_name        varchar(50)  NOT NULL,
--    last_name         varchar(50)  NOT NULL,
--    middle_name       varchar(50),
--    date_of_birth     date         NOT NULL,
--    CONSTRAINT fk_place_of_birth_id
--        FOREIGN KEY (place_of_birth_id) REFERENCES addresses (id),
--    CONSTRAINT fk_category_id
--        FOREIGN KEY (category_id) REFERENCES driving_license_categories (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS insurance_catalog
--(
--    id                    BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    company_id            BIGINT         NOT NULL,
--    address_id            BIGINT         NOT NULL,
--    type_id               BIGINT         NOT NULL,
--    insurance_period_id   integer        NOT NULL,
--    insurance_name        varchar(100),
--    description_insurance varchar(1000),
--    price_per_year        numeric(12, 2) NOT NULL,
--    CONSTRAINT fk_company_id
--        FOREIGN KEY (company_id) REFERENCES companies (id),
--    CONSTRAINT fk_address_id
--        FOREIGN KEY (address_id) REFERENCES addresses (id),
--    CONSTRAINT fk_type_id
--        FOREIGN KEY (type_id) REFERENCES types_of_insurance (id),
--    CONSTRAINT fk_insurance_period_id
--        FOREIGN KEY (insurance_period_id) REFERENCES insurance_durations (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS passports
--(
--    id                         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    place_of_birth_id          BIGINT,
--    address_of_registration_id BIGINT,
--    passport_series            varchar(50)  NOT NULL,
--    passport_number            varchar(50)  NOT NULL,
--    department_code            varchar(50)  NOT NULL,
--    date_of_issue              date         NOT NULL,
--    issuing_authority          varchar(255) NOT NULL,
--    first_name                 varchar(50)  NOT NULL,
--    last_name                  varchar(50)  NOT NULL,
--    middle_name                varchar(50),
--    gender                     char(1)      NOT NULL,
--    date_of_birth              date         NOT NULL,
--    UNIQUE (passport_series,
--            passport_number),
--    CONSTRAINT fk_place_of_birth_id
--        FOREIGN KEY (place_of_birth_id) REFERENCES addresses (id),
--    CONSTRAINT fk_address_of_registration_id
--        FOREIGN KEY (address_of_registration_id) REFERENCES addresses (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS transport_types
--(
--    id                    BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    transport_type        varchar(50) NOT NULL,
--    entity_type_id        integer,
--    is_taxi               boolean,
--    is_over_16_tons       boolean,
--    is_can_stop_anywhere  boolean,
--    is_over_16_pass_seats boolean,
--    CONSTRAINT fk_entity_type_id
--        FOREIGN KEY (entity_type_id) REFERENCES entity_types (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS base_rates
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    transport_type_id integer NOT NULL,
--    min_rate          integer NOT NULL,
--    max_rate          integer NOT NULL,
--    CONSTRAINT fk_transport_type_id
--        FOREIGN KEY (transport_type_id) REFERENCES transport_types (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS users
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    passport_id       BIGINT,
--    driver_license_id BIGINT,
--    phone_number      varchar(15)  NOT NULL UNIQUE,
--    email             varchar(255) NOT NULL UNIQUE,
--    hash_password     varchar(255) NOT NULL,
--    first_name        varchar(50)  NOT NULL,
--    last_name         varchar(50)  NOT NULL,
--    middle_name       varchar(50),
--    date_of_birth     date         NOT NULL,
--    role              varchar(50),
--    CONSTRAINT fk_passport_id
--        FOREIGN KEY (passport_id) REFERENCES passports (id),
--    CONSTRAINT fk_driver_license_id
--        FOREIGN KEY (driver_license_id) REFERENCES driver_licenses (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS cars
--(
--    id           BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    user_id      BIGINT,
--    car_number   varchar(15) NOT NULL,
--    make         varchar(50) NOT NULL,
--    model        varchar(50) NOT NULL,
--    car_type     varchar(50),
--    release_year integer     NOT NULL,
--    mileage      integer,
--    CONSTRAINT fk_user_id
--        FOREIGN KEY (user_id) REFERENCES users (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS consultations
--(
--    id                BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    user_id           BIGINT                              NOT NULL,
--    situation         varchar(255)                        NOT NULL,
--    created           timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
--    status            varchar(10)                         NOT NULL,
--    consultation_time timestamp WITH TIME ZONE,
--    CONSTRAINT fk_user_id
--        FOREIGN KEY (user_id) REFERENCES users (id)
--);
--
--
--CREATE TABLE IF NOT EXISTS issued_insurances
--(
--    id         BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
--    user_id    BIGINT                   NOT NULL,
--    company_id BIGINT                   NOT NULL,
--    type_id    BIGINT                   NOT NULL,
--    start_time timestamp WITH TIME ZONE NOT NULL,
--    end_time   timestamp WITH TIME ZONE NOT NULL,
--    price      numeric(12, 2)           NOT NULL,
--    CONSTRAINT fk_user_id
--        FOREIGN KEY (user_id) REFERENCES users (id),
--    CONSTRAINT fk_company_id
--        FOREIGN KEY (company_id) REFERENCES companies (id),
--    CONSTRAINT fk_type_id
--        FOREIGN KEY (type_id) REFERENCES types_of_insurance (id)
--)