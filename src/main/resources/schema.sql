CREATE TABLE IF NOT EXISTS users (
        id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
        username varchar(20) NOT NULL,
        email varchar(100) NOT NULL UNIQUE,
        password varchar(100) NOT NULL,
        avatar_id BIGINT NOT NULL,
        role varchar(20) NOT NULL,
        created_on timestamp NOT NULL,
        status varchar(25) NOT NULL
  );