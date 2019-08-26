create table login (
	id serial not null,
	usuario varchar(100),
	senha varchar(100),
	
	constraint id_pk_login primary key(id)
)