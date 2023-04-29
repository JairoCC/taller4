create table CLIENTE (
    id int PRIMARY KEY,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
    rol_id int not null
);

create table ROL (
    id int PRIMARY KEY,
    nombre varchar(100) not null
);

