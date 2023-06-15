CREATE TABLE IF NOT EXISTS rule
(
    id          serial PRIMARY KEY,
    name        text,
    accident_id int REFERENCES accidents (id)
);