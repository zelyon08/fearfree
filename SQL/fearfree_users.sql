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

INSERT INTO fearfree.users (id, nom, prenom, email, username, password, datenaissance, actif, lat, radus) VALUES (11, 'Ngadjui', 'Zeph', 'ngadjuiz1@google.fr', 'zelyon09', '$2a$10$VpsEq63R9oS7JxzyWMf4KuZPIMM2MufK32bCAj9hswIgsJSb6fVLG', '2023-03-21', 1, 0, 0);
INSERT INTO fearfree.users (id, nom, prenom, email, username, password, datenaissance, actif, lat, radus) VALUES (12, 'Tchamgoue', 'Yvana', 'Yvana@google.fr', 'Yvanou9', '$2a$10$QIgOJskeZox8H8HzZ8fldurTpqTsO7P3WbZacO9Ekkc73MrZlQUzK', '2023-03-02', 1, 0, 0);
