create table login ( 
	id serial NOT null,
	usuario varchar(100),
	senha varchar(100), 
	constraint id_pk_login primary key(id) 
);
CREATE TABLE usuarios (
	codigo serial,
	nome varchar(100),
	telefone varchar(20),
	endereco text,
	constraint codigo_pk primary key(codigo)
)