set sql_mode = '';

/* SCHEMA */

create table if not exists oauth_client_details
(
    client_id               varchar(255) not null,
    client_secret           varchar(255) not null,
    web_server_redirect_uri varchar(2048) default null,
    scope                   varchar(255)  default null,
    access_token_validity   int(11)       default null,
    refresh_token_validity  int(11)       default null,
    resource_ids            varchar(1024) default null,
    authorized_grant_types  varchar(1024) default null,
    authorities             varchar(1024) default null,
    additional_information  varchar(4096) default null,
    autoapprove             varchar(255)  default null,
    primary key (client_id)
) engine = innodb;

create table if not exists permission
(
    id   int(11) not null auto_increment,
    name varchar(512) default null,
    primary key (id),
    unique key name (name)
) engine = innodb;

create table if not exists role
(
    id   int(11) not null auto_increment,
    name varchar(255) default null,
    primary key (id),
    unique key name (name)
) engine = innodb;

create table if not exists user
(
    id                      int(11)       not null auto_increment,
    username                varchar(100)  not null,
    password                varchar(1024) not null,
    email                   varchar(1024) not null,
    enabled                 tinyint(4)    not null,
    account_non_expired     tinyint(4)    not null,
    credentials_non_expired tinyint(4)    not null,
    account_non_locked      tinyint(4)    not null,
    primary key (id),
    unique key username (username)
) engine = innodb;

create table if not exists permission_role
(
    permission_id int(11) default null,
    role_id       int(11) default null,
    key permission_id (permission_id),
    key role_id (role_id),
    constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id),
    constraint permission_role_ibfk_2 foreign key (role_id) references role (id)
) engine = innodb;

create table if not exists role_user
(
    role_id int(11) default null,
    user_id int(11) default null,
    key role_id (role_id),
    key user_id (role_id),
    constraint user_role_ibfk_1 foreign key (role_id) references role (id),
    constraint user_role_ibfk_2 foreign key (user_id) references user (id)
) engine = innodb;

/* INSERT DATA */
insert into oauth_client_details (
    client_id,
    client_secret,
    web_server_redirect_uri,
    scope,
    access_token_validity,
    refresh_token_validity,
    resource_ids,
    authorized_grant_types,
    additional_information)
values ('mobile',
        '$2a$10$w1AHikucQz1gWuvhOSvGyevzoIl1QmBUvYpxdva8Aeaf0am2U0s2u',
        'http://localhost:8080/code',
        'READ,WRITE',
        '3600',
        '10000',
        'inventory,payment',
        'authorization_code,password,refresh_token,implicit',
        '{}');

insert into permission (name)
values ('create_employee'), ('read_employee'), ('update_employee'), ('delete_employee');

insert into role (name)
values ('ROLE_admin'), ('ROLE_operator');

insert into permission_role (role_id, permission_id)
values (1, 1), (1, 2), (1, 3), (1, 4), /* admin role has all permissions */
       (2, 2), (2, 3) /* operator has read and update permissions only */ ;

insert into user (username,
                  password,
                  email,
                  enabled,
                  account_non_expired,
                  credentials_non_expired,
                  account_non_locked)
values ('profx',
        '$2a$10$ZM2YX4zHTXgm2JX87ETRmeAv.wLIQdWvxDfL6miCEug6fn53CdMIy',
        'miller@millertronics.com',
        1, 1, 1, 1),
       ('magneto',
        '$2a$10$k2fASsrKcxj1/9AKHqfGouO.I68fAa2ic1wGccQVn92CdK9cX2zFa',
        'hawkwood@millertronics',
        1, 1, 1, 1);

insert into role_user (user_id, role_id)
values (1, 1), (1, 1);
