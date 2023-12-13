CREATE TABLE IF NOT EXISTS driver_number_coefficient (
    id BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    coefficient_name varchar(100) NOT NULL,
    coefficient_value NUMERIC(3, 2) NOT NULL
)