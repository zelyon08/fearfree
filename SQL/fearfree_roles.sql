create table roles
(
    role_id int auto_increment
        primary key,
    name    varchar(45) not null
);

INSERT INTO fearfree.roles (role_id, name) VALUES (1, 'USER');
INSERT INTO fearfree.roles (role_id, name) VALUES (2, 'ADMIN');
INSERT INTO fearfree.roles (role_id, name) VALUES (3, 'INVITE');
