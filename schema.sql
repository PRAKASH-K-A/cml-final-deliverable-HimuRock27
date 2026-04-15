CREATE DATABASE trading_system;

USE trading_system;

CREATE TABLE orders (
    order_id VARCHAR(50),
    symbol VARCHAR(20),
    side CHAR(1),
    price DOUBLE,
    quantity DOUBLE,
    status VARCHAR(20)
);