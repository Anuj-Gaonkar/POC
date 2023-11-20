ALTER TABLE public.token
ADD CONSTRAINT fk_token_users FOREIGN KEY (user_id) REFERENCES users (id);