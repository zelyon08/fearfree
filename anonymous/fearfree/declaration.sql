create table declaration
(
    id          int auto_increment
        primary key,
    idincident  int          not null,
    statut      varchar(15)  not null,
    date        datetime     not null,
    commentaire varchar(200) null,
    constraint idincident
        foreign key (idincident) references incident (id)
);

