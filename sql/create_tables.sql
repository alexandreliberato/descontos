CREATE TABLE IF NOT EXISTS products (
    id UUID PRIMARY KEY NOT NULL,
    title varchar(128) NOT NULL,
    description varchar(256) NOT NULL,
    price_in_cents integer NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY NOT NULL,
    first_name varchar(128) NOT NULL,
    last_name varchar(128) NOT NULL,
    date_of_birth timestamp NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS date_discount_rules (
    id UUID PRIMARY KEY NOT NULL,
    title varchar(128) NOT NULL,
    percentage decimal(5,2) NOT NULL,
    discount_limit decimal(5,2) NOT NULL,
    discount_date timestamp NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
