create table crimes
(
    id  int auto_increment
        primary key,
    nom varchar(100) not null,
    constraint crimes_nom_uindex
        unique (nom)
);

INSERT INTO fearfree.crimes (id, nom) VALUES (3, 'agression a l''arme a feu');
INSERT INTO fearfree.crimes (id, nom) VALUES (2, 'agression a l''arme blanche');
INSERT INTO fearfree.crimes (id, nom) VALUES (1, 'agression sans arme');
INSERT INTO fearfree.crimes (id, nom) VALUES (4, 'carjacking / vol de voiture');
INSERT INTO fearfree.crimes (id, nom) VALUES (5, 'kidnapping');
INSERT INTO fearfree.crimes (id, nom) VALUES (6, 'meutre');
