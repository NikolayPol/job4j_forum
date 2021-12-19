create table posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

INSERT INTO public.posts(id, name, description, created)
VALUES (1, "Тема Java", "Описание", 2021 - 12 - 17 06:52:53.934138);