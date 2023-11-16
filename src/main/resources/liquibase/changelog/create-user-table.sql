CREATE TABLE IF NOT EXISTS public.users
(
    id uuid NOT NULL,
    public_id uuid NOT NULL,
    version bigint DEFAULT 0,
    created_date TIMESTAMP NOT NULL,
    last_modified_date TIMESTAMP,
    created_by character varying(75) NOT NULL,
    last_modified_by character varying(75),
    email character varying(75) NOT NULL,
    phone_number varchar(20) NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name varchar(100) NOT NULL,
    other_name varchar(100),
    password varchar(100) NOT NULL,
    role varchar(50) NOT NULL,
    status varchar(50),
    is_enabled boolean,
    is_user_account_expired boolean,
    is_user_account_locked boolean,
    is_user_account_credentials_expired boolean,
    PRIMARY KEY (id),
    CONSTRAINT unique_order_invoice_details_public_id UNIQUE (public_id)
);