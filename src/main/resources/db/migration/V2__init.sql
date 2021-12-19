drop table if exists roles;
create table roles (
    id bigserial primary key,
    role varchar(30) not null unique
);
insert into roles (role)  values ('ROLE_PARENT'), ('ROLE_CHILDREN');

drop table  if exists parents;
create table parents (
                         id              bigserial primary key,
                         login           varchar(30) not null unique,
                         password        varchar(80) not null,
                         id_role         integer not null REFERENCES roles(id)
);

drop table  if exists children;
create table children (
                          id              bigserial primary key,
                          login           varchar(30) not null unique,
                          password        varchar(80) not null,
                          wallet           integer,
                          id_role         integer not null REFERENCES roles(id)
);

drop table  if exists bonuses;
create table bonuses (
                          id              bigserial primary key,
                          title           varchar(80) not null,
                          id_parent       integer not null REFERENCES parents(id),
                          id_child        integer REFERENCES children(id),
                          price             integer not null,
                          received_at      timestamp
);

drop table  if exists tasks;
create table tasks (
                       id              bigserial primary key,
                       title           varchar(30) not null,
                       description     varchar(80),
                       created_at      timestamp default current_timestamp,
                       updated_at      timestamp,
                       id_parent       integer not null REFERENCES parents(id),
                       id_child        integer REFERENCES children(id),
                       cost            integer not null
);


insert into parents (login, password, id_role)
values
    ('parent1', '111', 1),
    ('parent2', '222', 1);

insert into children (login, password, wallet, id_role)
values
    ('child1', '111', 0, 2),
    ('child2', '222', 20, 2),
    ('child3', '333', 55, 2);

insert into tasks (title, id_parent, id_child, cost)
values
    ('Тестовая задача 1',1,1,2),
    ('Brush teeth',1,2,15),
    ('trow iut the trash',2,3,21);


insert into bonuses (title, id_parent, price)
values
    ('bicycle', 1, 15),
    ('gun', 2, 99);
commit;