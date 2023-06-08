create table Historique
(
    id       int auto_increment
        primary key,
    nomcrime varchar(1000) not null,
    statut   varchar(20)   not null,
    date     date          not null,
    iduser   int           not null,
    constraint Historique_id_uindex
        unique (id),
    constraint iduser
        foreign key (iduser) references users (id),
    constraint FKcb4wco3skvm36yn5n70kna6hg
        foreign key (iduser) references users (id)
);

