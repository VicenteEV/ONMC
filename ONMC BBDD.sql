create table if not exists Usuario(
ID_Usuario serial primary key,
Usuario varchar(20) UNIQUE,
Contraseña varchar(30),
Correo_Electronico varchar(50),
Nombre varchar(20),
Apellidos varchar(50),
Fecha_Nacimiento date
);

create table if not exists Partida(
ID_Partida serial primary key,
Fecha timestamp,
Victoria boolean,
comentario varchar(50)
);

create table if not exists Usuario_Partida(
id_Usuario int references Usuario on update cascade on delete restrict, 
id_Partida int references Partida on update cascade on delete restrict,
Puntuacion int,
Victorias int,
Partidas_Totales int,
primary key (id_Usuario, id_Partida)
);

alter table usuario rename Contraseña to contrasenya;
alter table usuario alter contrasenya type varchar(150);

