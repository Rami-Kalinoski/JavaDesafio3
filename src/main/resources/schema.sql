DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR (75),
    apellido VARCHAR (75),
    fecha_nacimiento DATE
);