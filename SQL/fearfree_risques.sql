create table risques
(
    id     int auto_increment
        primary key,
    `long` double          not null,
    lat    double          not null,
    radus  int default 200 null,
    constraint risques_id_uindex
        unique (id)
);

