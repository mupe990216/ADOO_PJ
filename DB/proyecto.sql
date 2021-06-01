drop database if exists prueba;
create database prueba;
use prueba;

create table if not exists Credencial(
  Usuario varchar(64) not null,
  Contrasenia varchar(64) not null,
  primary key(Usuario,Contrasenia)
);

create table if not exists TipoUsuario(
  idTipoUsuario int(2) not null primary key,
  Descripcion varchar(64) not null
);

insert into TipoUsuario values(1,'Administrador');
insert into TipoUsuario values(2,'Cliente');

create table if not exists Persona(
  Email varchar(64) not null primary key,
  Nombre varchar(64) not null,
  ApePaterno varchar(64) not null,
  ApeMaterno varchar(64) not null,
  Usuario varchar(64) not null,
  Contrasenia varchar(64) not null,
  idTipoUsuario int(2) not null,
  foreign key (Usuario) references Credencial(Usuario) on delete cascade on update cascade,
  foreign key (Contrasenia) references Credencial(Contrasenia) on delete cascade on update cascade,
  foreign key (idTipoUsuario) references TipoUsuario(idTipoUsuario) on delete cascade on update cascade
);

-- Validar un SP para que solo un usuario del tipo 1 
-- Pueda agregar info a esta tabla
create table if not exists Gestiona_Persona(
  idRegistro int(16) not null primary key,
  Email_Admin varchar(64) not null,
  Email_Modificado  varchar(64) not null,
  FechaRegistro timestamp default current_timestamp,
  foreign key (Email_Admin) references Persona(Email) on delete cascade on update cascade,
  foreign key (Email_Modificado) references Persona(Email) on delete cascade on update cascade
);

create table if not exists Cat_Publicacion(
  idCategoria int(2) not null primary key,
  Descripcion varchar(64) not null
);

insert into Cat_Publicacion values(1,'Alimento');
insert into Cat_Publicacion values(2,'Comportamiento');
insert into Cat_Publicacion values(3,'Adiestramiento');
insert into Cat_Publicacion values(4,'Juguetes');
insert into Cat_Publicacion values(5,'Salud');

create table if not exists Publicacion(
  idModulo int(16) not null primary key,
  Titulo varchar(64) not null,
  Descripcion varchar(2048) not null,
  Imagen varchar(128),
  idCategoria int(2) not null,
  foreign key (idCategoria) references Cat_Publicacion(idCategoria) on delete cascade on update cascade
);

-- Validar un SP para que solo un usuario del tipo 1 
-- Pueda agregar info a esta tabla
create table if not exists Gestiona_Publicacion(
  idRegistro int(16) not null primary key,
  Email_Admin varchar(64) not null,
  idPublicacion int(16) not null,
  FechaRegistro timestamp default current_timestamp,
  foreign key (Email_Admin) references Persona(Email) on delete cascade on update cascade,
  foreign key (idPublicacion) references Publicacion(idModulo) on delete cascade on update cascade
);

create table if not exists Foro(
  idForo int(64) not null primary key,
  Titulo varchar(64) not null,
  Descripcion varchar(2048) not null,
  Email_Admin varchar(64) not null,
  foreign key (Email_Admin) references Persona(Email) on delete cascade on update cascade
);

-- Validar un SP para que solo un usuario del tipo 1 
-- Pueda agregar info a esta tabla
create table if not exists Gestiona_Foro(
  idRegistro int(16) not null primary key,
  Email_Admin varchar(64) not null,
  idForo int(64) not null,
  FechaRegistro timestamp default current_timestamp,
  foreign key (Email_Admin) references Persona(Email) on delete cascade on update cascade,
  foreign key (idForo) references Foro(idForo) on delete cascade on update cascade
);

create table if not exists Mensaje(
  idMsj int(64) not null,
  idForo int(64) not null,
  Descripcion varchar(2048) not null,
  Email_Cliente varchar(64) not null,
  foreign key (Email_Cliente) references Persona(Email) on delete cascade on update cascade,
  foreign key (idForo) references Foro(idForo) on delete cascade on update cascade,
  primary key (idMsj,idForo)
);






