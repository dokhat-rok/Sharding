--liquibase formatted sql

--changeset dmitry.krivenko:202303162300-1
create table if not exists public.user (
    id          bigserial   not null,
    login       varchar     not null,
    city        varchar     not null,
    status      varchar     not null,

    constraint user_id              primary key (id),
    constraint user_unique_fields   unique      (login)
);

--changeset dmitry.krivenko:202303162330-2
create table if not exists public.order (
    id          bigserial   not null,
    user_id     bigint      not null,
    product     varchar     not null,
    count       bigint      not null,

    constraint  order_id    primary key (id),
    foreign key (user_id)   references  "user"(id)
);