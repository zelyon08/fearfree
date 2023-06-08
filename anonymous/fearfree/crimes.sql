create table crimes
(
    id  int auto_increment
        primary key,
    nom varchar(100) not null,
    constraint crimes_nom_uindex
        unique (nom)
);

