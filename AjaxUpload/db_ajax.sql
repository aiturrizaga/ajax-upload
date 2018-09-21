CREATE DATABASE Ajax;

USE Ajax;

CREATE TABLE Usuario (
	id_user		int primary key auto_increment not null,
	nom_user	varchar(50),
	pass_user	varchar(100),
    img_user	varchar(100)
);

SELECT * FROM Usuario;
