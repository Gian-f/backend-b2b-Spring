CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    status BOOLEAN NOT NULL,
    cpf VARCHAR(14),
    password VARCHAR(255) NOT NULL,
    confirm_password VARCHAR(255) NOT NULL,
    terms_conditions BOOLEAN,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);