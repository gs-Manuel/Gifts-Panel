DROP DATABASE IF EXISTS panelRegalos;
CREATE DATABASE panelRegalos;
use panelregalos;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS producto;
CREATE TABLE producto(
	id_producto INT unsigned AUTO_INCREMENT,
    nombre_producto VARCHAR(100) NOT NULL,
    descripcion VARCHAR(500),
    coste INT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    imagen BLOB DEFAULT NULL,
    PRIMARY KEY(id_producto),
    CONSTRAINT tipo_check CHECK (tipo="alimentacion"
		OR tipo = "deporte" OR tipo = "electronica" OR tipo = "juguete" OR tipo = "experiencia")
);
CREATE TABLE usuario(
	id_usuario INT unsigned AUTO_INCREMENT,
    nombre_usuario VARCHAR(28) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    correo VARCHAR(70) NOT NULL UNIQUE,
    puede_jugar BOOL DEFAULT false,
    ha_jugado BOOL DEFAULT false,
    puntos INT DEFAULT 0,
    tipo_usuario enum("administrador","usuario") DEFAULT "usuario",
    id_producto INT unsigned,
	observaciones VARCHAR(500),
    PRIMARY KEY(id_usuario),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

