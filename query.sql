create table login ( 
	id serial NOT null,
	usuario varchar(100),
	senha varchar(100), 
	constraint id_pk_login primary key(id) 
)