-- enabling extension so we can generate a UUID
CREATE EXTENSION pgcrypto;

insert into users (id, first_name, last_name, date_of_birth) values (
    gen_random_uuid(),
    'Yuri',
    'Gagarin',
    TO_TIMESTAMP('1935-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
);


insert into products values (
    gen_random_uuid(),
    'Boots',
    'Super boots.',
    9999
);

insert into date_discount_rules values (
    gen_random_uuid(),
    'Black Friday',
    0.10,
    0.10,
    TO_TIMESTAMP('11-25', 'MM-DD')
);

