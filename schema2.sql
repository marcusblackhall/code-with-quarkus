DROP TABLE IF EXISTS person;
CREATE TABLE IF NOT EXISTS person (

    id INT generated always as identity ,
    name varchar(255),
    email varchar(255)

);
