CREATE TABLE IF NOT EXISTS addresses (id BIGSERIAL PRIMARY KEY,
                                      country varchar(50) NOT NULL,
                                      region varchar(50) NOT NULL,
                                      city varchar(50) NOT NULL,
                                      street varchar(100),
                                      house_number varchar(10),
                                      apartment_number varchar(10),
                                      postal_code varchar(10),
                                      UNIQUE (country,
                                              region,
                                              city,
                                              street,
                                              house_number,
                                              apartment_number,
                                              postal_code));


CREATE TABLE IF NOT EXISTS application_for_individual_insurances (id BIGSERIAL PRIMARY KEY,
                                                                  phone_number varchar(15) NOT NULL,
                                                                  email varchar(255) NOT NULL,
                                                                  first_name varchar(255) NOT NULL,
                                                                  last_name varchar(255) NOT NULL,
                                                                  middle_name varchar(255),
                                                                  description_of_situation varchar(1000) NOT NULL,
                                                                  policy_holder varchar(50) NOT NULL);


CREATE TABLE IF NOT EXISTS company_news (id BIGSERIAL PRIMARY KEY,
                                         title varchar(255) NOT NULL,
                                         text varchar NOT NULL,
                                         created_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL);


CREATE TABLE IF NOT EXISTS consultations_for_unregistered_users (id BIGSERIAL PRIMARY KEY,
                                                                 first_name varchar(255) NOT NULL,
                                                                 last_name varchar(255) NOT NULL,
                                                                 phone_number varchar(15) NOT NULL,
                                                                 situation varchar(255) NOT NULL,
                                                                 created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                                                 status varchar(10) NOT NULL,
                                                                 consultation_time timestamp WITH TIME ZONE);


CREATE TABLE IF NOT EXISTS contact_types (id BIGSERIAL PRIMARY KEY,
                                          contact_name varchar(255) NOT NULL,
                                          contact_value varchar(255) NOT NULL UNIQUE);


CREATE TABLE IF NOT EXISTS creators_of_project (id BIGSERIAL PRIMARY KEY,
                                                first_name varchar(50) NOT NULL,
                                                last_name varchar(50) NOT NULL,
                                                role varchar(255) NOT NULL,
                                                description varchar(1000));


CREATE TABLE IF NOT EXISTS driving_license_categories (id serial PRIMARY KEY,
                                                       category varchar(10) NOT NULL);


CREATE TABLE IF NOT EXISTS entity_types (id serial PRIMARY KEY,
                                         entity_type varchar(50) NOT NULL);


CREATE TABLE IF NOT EXISTS faqs (id BIGSERIAL PRIMARY KEY,
                                 question varchar NOT NULL,
                                 answer varchar NOT NULL,
                                 tags varchar(255));


CREATE TABLE IF NOT EXISTS insurance_durations (id serial PRIMARY KEY,
                                                insurance_duration integer NOT NULL);


CREATE TABLE IF NOT EXISTS licenses (id BIGSERIAL PRIMARY KEY,
                                     license varchar(1000) NOT NULL,
                                     received_date date);


CREATE TABLE IF NOT EXISTS news_writers (id serial PRIMARY KEY,
                                         first_name varchar(255) NOT NULL,
                                         last_name varchar(255) NOT NULL);


CREATE TABLE IF NOT EXISTS types_of_insurance (id BIGSERIAL PRIMARY KEY,
                                               TYPE varchar(255) NOT NULL);


CREATE TABLE IF NOT EXISTS company_contacts (id BIGSERIAL PRIMARY KEY,
                                             address_id BIGINT REFERENCES addresses (id),
                                             contact_types_id BIGINT REFERENCES contact_types (id));


CREATE TABLE IF NOT EXISTS about_project (id BIGSERIAL PRIMARY KEY,
                                          contact_id BIGINT REFERENCES company_contacts (id) NOT NULL,
                                          creator_id BIGINT REFERENCES creators_of_project (id) NOT NULL,
                                          description varchar NOT NULL);


CREATE TABLE IF NOT EXISTS collaborations (id BIGSERIAL PRIMARY KEY,
                                           company_contact_id BIGINT REFERENCES company_contacts (id) NOT NULL,
                                           company_name varchar(255) NOT NULL,
                                           inn char(10) NOT NULL UNIQUE,
                                           ogrn char(13) NOT NULL UNIQUE,
                                           type_of_insurance varchar, special_offer varchar(1000),
                                           strategic_goals varchar(1000),
                                           message varchar(1000) NOT NULL,
                                           created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                           status varchar(10) NOT NULL);


CREATE TABLE IF NOT EXISTS companies (id BIGSERIAL PRIMARY KEY,
                                      type_id BIGINT REFERENCES types_of_insurance (id) NOT NULL,
                                      contact_id BIGINT REFERENCES company_contacts (id) NOT NULL,
                                      address_id BIGINT REFERENCES addresses (id),
                                      license_id BIGINT REFERENCES licenses (id) NOT NULL,
                                      company_name varchar(255) NOT NULL,
                                      foundation_date date,
                                      rating numeric(2, 1) NOT NULL CHECK (rating <= 5.0),
                                      number_of_clients integer);


CREATE TABLE IF NOT EXISTS driver_licenses (id BIGSERIAL PRIMARY KEY,
                                            place_of_birth_id BIGINT REFERENCES addresses (id) NOT NULL,
                                            category_id integer REFERENCES driving_license_categories (id) NOT NULL,
                                            license_number varchar(50) NOT NULL,
                                            date_of_issue date NOT NULL,
                                            date_of_expiry date NOT NULL,
                                            issuing_authority varchar NOT NULL,
                                            first_name varchar(255) NOT NULL,
                                            last_name varchar(255) NOT NULL,
                                            middle_name varchar(255),
                                            date_of_birth date NOT NULL);


CREATE TABLE IF NOT EXISTS insurance_catalog (id BIGSERIAL PRIMARY KEY,
                                              company_id BIGINT REFERENCES companies (id) NOT NULL,
                                              address_id BIGINT REFERENCES addresses (id) NOT NULL,
                                              type_id BIGINT REFERENCES types_of_insurance (id) NOT NULL,
                                              insurance_period_id integer REFERENCES insurance_durations (id) NOT NULL,
                                              insurance_name varchar(255),
                                              description_insurance varchar(1000),
                                              price_per_year numeric(12, 2) NOT NULL);


CREATE TABLE IF NOT EXISTS passports (id BIGSERIAL PRIMARY KEY,
                                      place_of_birth_id BIGINT REFERENCES addresses (id),
                                      address_of_registration_id BIGINT REFERENCES addresses (id),
                                      passport_series varchar(50) NOT NULL,
                                      passport_number varchar(50) NOT NULL,
                                      department_code varchar(50) NOT NULL,
                                      date_of_issue date NOT NULL,
                                      issuing_authority varchar NOT NULL,
                                      first_name varchar(255) NOT NULL,
                                      last_name varchar(255) NOT NULL,
                                      middle_name varchar(255),
                                      gender char(1) NOT NULL,
                                      date_of_birth date NOT NULL,
                                      UNIQUE (passport_series,
                                              passport_number));


CREATE TABLE IF NOT EXISTS transport_types (id serial PRIMARY KEY,
                                            transport_type varchar(50) NOT NULL,
                                            entity_type_id integer REFERENCES entity_types (id),
                                            is_taxi boolean,
                                            is_over_16_tons boolean,
                                            is_can_stop_anywhere boolean,
                                            is_over_16_pass_seats boolean);


CREATE TABLE IF NOT EXISTS base_rates (id serial PRIMARY KEY,
                                       transport_type_id integer REFERENCES transport_types (id) NOT NULL,
                                       min_rate integer NOT NULL,
                                       max_rate integer NOT NULL);


CREATE TABLE IF NOT EXISTS users (id BIGSERIAL PRIMARY KEY,
                                  passport_id BIGINT REFERENCES passports (id),
                                  driver_license_id BIGINT REFERENCES driver_licenses (id),
                                  phone_number varchar(15) NOT NULL UNIQUE,
                                  email varchar(255) NOT NULL UNIQUE,
                                  hash_password varchar(255) NOT NULL,
                                  first_name varchar(255) NOT NULL,
                                  last_name varchar(255) NOT NULL,
                                  middle_name varchar(255),
                                  date_of_birth date NOT NULL,
                                  role varchar(50));


CREATE TABLE IF NOT EXISTS cars (id BIGSERIAL PRIMARY KEY,
                                 user_id BIGINT REFERENCES users (id),
                                 car_number varchar(15) NOT NULL,
                                 make varchar(50) NOT NULL,
                                 model varchar(50) NOT NULL,
                                 car_type varchar(50),
                                 release_year integer NOT NULL,
                                 mileage integer);


CREATE TABLE IF NOT EXISTS consultations (id BIGSERIAL PRIMARY KEY,
                                          user_id BIGINT REFERENCES users (id) NOT NULL,
                                          situation varchar(255) NOT NULL,
                                          created timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
                                          status varchar(10) NOT NULL,
                                          consultation_time timestamp WITH TIME ZONE);


CREATE TABLE IF NOT EXISTS issued_insurances (id BIGSERIAL PRIMARY KEY,
                                              user_id BIGINT REFERENCES users (id) NOT NULL,
                                              company_id BIGINT REFERENCES companies (id) NOT NULL,
                                              type_id BIGINT REFERENCES types_of_insurance (id) NOT NULL,
                                              start_time timestamp WITH TIME ZONE NOT NULL,
                                              end_time timestamp WITH TIME ZONE NOT NULL,
                                              price numeric(12, 2) NOT NULL)