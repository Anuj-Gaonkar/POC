CREATE TABLE IF NOT EXISTS public.token
(
    id uuid NOT NULL,
    token varchar(20) NOT NULL,
    token_type varchar(20) NOT NULL,
    revoked boolean,
    expired boolean,
    user_id uuid NOT NULL,
    PRIMARY KEY (id)
);