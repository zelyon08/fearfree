create table users
(
    id            int auto_increment
        primary key,
    nom           varchar(200)         not null,
    prenom        varchar(200)         not null,
    email         varchar(200)         not null,
    username      varchar(20)          not null,
    password      varchar(100)         not null,
    datenaissance date                 null,
    actif         tinyint(1) default 1 not null,
    lat           double               not null,
    radus         int                  not null,
    constraint email_UNIQUE
        unique (email),
    constraint username
        unique (username)
);

