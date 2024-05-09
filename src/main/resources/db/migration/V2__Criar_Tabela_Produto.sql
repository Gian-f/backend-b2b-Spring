CREATE TABLE IF NOT EXISTS product (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price NUMERIC(10, 2) NOT NULL,
    description TEXT NOT NULL,
    category_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id)
);