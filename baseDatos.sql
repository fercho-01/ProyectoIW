/*jose gilberto*/

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
CREATE DATABASE `prueba` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `prueba`;


create table if not exists `usuario`(
  cedula varchar(15) not null,
  password varchar(30) not null,
  nombre varchar(60) not null,
  emain varchar(120) not null,
  primary key(cedula)
);

create table if not exists `empleado`(
  cedula varchar(15) not null,
  password varchar(30) not null,
  nombre varchar(60) not null,
  email varchar(120) not null,
  cargo varchar(30) not null,
  primary key(cedula)
);

create table if not exists `pqr`(
  usuario varchar(15) not null,
  id int(12) not null auto_increment,
  tipo varchar(30) not null,
  estado varchar(10) not null,
  descripcion varchar(200) not null,
  respuesta varchar(200),
  empleado varchar(15),
  fechaRespuesta date,
  fechaSolicitud date,
  primary key(id),
  foreign key(usuario) references usuario(cedula),
  foreign key(empleado) references empleado(cedula)
);

create table if not exists `encuesta`(
  usuario varchar(15) not null,
  idPqr int(12) not null,
  id int(15)  auto_increment,
  descripcion varchar(200) not null,
  fecha date,
  primary key(id),
  foreign key(usuario) references usuario(cedula),
  foreign key(idPqr) references pqr(id)
);
