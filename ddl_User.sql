CREATE TABLE "user"
(
    id           UUID         NOT NULL,
    username     VARCHAR(20)  NOT NULL,
    user_email   VARCHAR(255) NOT NULL,
    phone_number VARCHAR(255) NOT NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE,
    updated_at   VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_username UNIQUE (username);