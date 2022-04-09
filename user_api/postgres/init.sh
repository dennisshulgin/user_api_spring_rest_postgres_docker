#!/bin/bash
set -e

psql -v ON_ERROR_STOP=0 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE user_api;
    CREATE DATABASE denis;
    GRANT ALL PRIVILEGES ON DATABASE user_api TO denis;
    CREATE TABLE users (
          id SERIAL,
          name VARCHAR,
          surname VARCHAR,
          username VARCHAR,
          age INT
        );
    INSERT INTO users(name, surname, username, age) VALUES ('Denis', 'Shulgin', 'denissh', 24);
    INSERT INTO users(name, surname, username, age) VALUES ('Oksana', 'Mironova', 'oks', 23);
    INSERT INTO users(name, surname, username, age) VALUES ('Sanya', 'Smirnov', 'smir', 24);
EOSQL






