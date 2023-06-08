create table users_roles
(
    user_id int not null,
    role_id int not null,
    constraint role_fk
        foreign key (role_id) references roles (role_id),
    constraint user_fk
        foreign key (user_id) references users (id)
);

create index role_fk_idx
    on users_roles (role_id);

create index user_fk_idx
    on users_roles (user_id);

INSERT INTO fearfree.users_roles (user_id, role_id) VALUES (11, 2);
INSERT INTO fearfree.users_roles (user_id, role_id) VALUES (12, 1);
