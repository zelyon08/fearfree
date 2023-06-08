create table alerte
(
    id            int auto_increment
        primary key,
    statut        tinyint(1) not null,
    iddeclaration int        not null,
    constraint iddeclaration
        foreign key (iddeclaration) references declaration (id)
);

