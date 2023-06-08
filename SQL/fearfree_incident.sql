create table incident
(
    id           int auto_increment
        primary key,
    idcrime      int  not null,
    idrisque     int  not null,
    dateincident date not null,
    iddeclarant  int  null,
    user_id      int  null,
    constraint FK9o12oocjk2ge9dpt2t983hxes
        foreign key (user_id) references users (id),
    constraint idcrime
        foreign key (idcrime) references crimes (id),
    constraint iddeclarant
        foreign key (iddeclarant) references users (id),
    constraint idrisque
        foreign key (idrisque) references risques (id),
    constraint FKxor4ihcfu7pft67rvhh666tx
        foreign key (idrisque) references users (id)
);

