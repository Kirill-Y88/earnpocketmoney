drop table  if exists parents;
create table parents (
                         id              bigserial primary key,
                         login           varchar(30) not null unique,
                         password        varchar(80) not null
);

drop table  if exists children;
create table children (
                          id              bigserial primary key,
                          login           varchar(30) not null unique,
                          password        varchar(80) not null,
                          wallet           integer
);

drop table  if exists bonuses;
create table bonuses (
                          id              bigserial primary key,
                          title           varchar(80) not null,
                          task_text       varchar(255),
                          id_parent       integer not null REFERENCES parents(id),
                          id_child        integer REFERENCES children(id),
                          price             integer not null,
                          received_at      timestamp
);

drop table  if exists tasks;
create table tasks (
                       id              bigserial primary key,
                       title           varchar(30) not null,
                       task_text       varchar(255),
                       description     varchar(80),
                       created_at      timestamp default current_timestamp,
                       updated_at      timestamp,
                       id_parent       integer not null REFERENCES parents(id),
                       id_child        integer REFERENCES children(id),
                       cost            integer not null
);


insert into parents (login, password)
values
    ('parent1', '111'),
    ('parent2', '222');

insert into children (login, password, wallet)
values
    ('child1', '111', 0),
    ('child2', '222', 20),
    ('child3', '333', 55);

insert into tasks (id, title, task_text, id_parent, id_child, cost)
values
    (1L, 'Тестовая задача 1', 'gsdffdsfdf', 1,1,2),
    (2L, 'Brush teeth', 'gsdfdfdff',1,2,15),
    (3L, 'Throw out the trash', 'gssf dsfdf', 2,3,21);

insert into bonuses (title, task_text, id_parent, price)
values
    ('bicycle', 'dsdsadsad', 1, 15),
    ('gun','fddgfdgfdgddsf', 2, 99);
commit;