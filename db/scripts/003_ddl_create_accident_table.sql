CREATE TABLE IF NOT EXISTS accident
(
    id   serial PRIMARY KEY,
    name text,
    description text,
    address text,
    accident_type_id int REFERENCES accident_type(id)

);