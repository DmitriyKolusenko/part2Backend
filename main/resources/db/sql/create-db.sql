CREATE TABLE products (
  id   INTEGER PRIMARY KEY,
  name VARCHAR(500),
  price  DECIMAL,
  weight DOUBLE,
  in_stock BIGINT,
  category VARCHAR(50),
  volume DOUBLE
);

CREATE TABLE clients (
  id   INTEGER PRIMARY KEY,
  name VARCHAR(500),
  surname  VARCHAR(500),
  email  VARCHAR(500),
  password  VARCHAR(500),
  birthdate DATE
);