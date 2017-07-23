
create database projeto1bim2017;

use projeto1bim2017;

create table usuario (
    usuEmail varchar(20) not null,
    usuSenha varchar (30)not null,
    usuNome varchar(50) not null,
    primary key (usuEmail)
);

create table evento(
	evId int not null auto_increment,
    evDescricao varchar (200) null,
    evCategoria varchar(20) null,
    evQndPrevistaDePessoas int null,
    evNome varchar(20),
	evElaboradorEmail varchar (20),
    evPontuacao int,
    evDataDeOcorrencia date,
    evlocal varchar(50),
    primary key(evId),
    FOREIGN KEY (evElaboradorEmail) references usuario(usuEmail)
 );

 create table publicacao(
		pubUsuEmail varchar(30) not null,
        pubEvId int not null,
        pubData date not null,
        primary key (pubUsuEmail,pubEvId),
        foreign key (pubUsuEmail) references usuario(usuEmail),
        foreign key (pubEvId) references evento(evId)
 );
 
 create table edicao(
	edUsuEmail varchar(30) not null,
    edEvId int not null,
	edData date not null,
	primary key (edUsuEmail,edEvId),
	foreign key(edUsuEmail) references usuario(usuEmail),
	foreign key(edEvId) references evento(evId)
 );

 
create table exclusao(
	delUsuEmail varchar(20) not null,
    delEvId int not null, 
    delEvNome varchar(20),
	primary key (delUsuEmail,delEvId),
    foreign key (delUsuEmail) references usuario (usuEmail),
    foreign key (delEvId) references evento (evId)
);
 
create table avaliacao(
	avUsuEmail varchar(20) not null,
    avEvId int not null,
    avNota int,
    primary key(avUsuEmail,AvEvId),
    foreign key (avUsuEmail) references usuario (usuEmail),
    foreign key (avEvId) references evento (evId)
);

create table favoritos (
	favUsuEmail varchar(20) not null,
    favEvId int not null,
    primary key (favUsuEmail, favEvId),
    foreign key (favUsuEmail) references usuario(usuEmail),
    foreign key (favEvId) references evento (evId)
);