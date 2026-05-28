
CREATE TABLE product
(
    product_id   UUID NOT NULL,
    product_name VARCHAR(100) NOT NULL,
    description  VARCHAR(500),
    price        DECIMAL(10, 2) NOT NULL,
    stock smallint NOT NULL,
    category     VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    updated_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (product_id)
);