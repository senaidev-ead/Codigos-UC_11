drop database if exists contasbanco;

create database contasbanco;

use contasbanco;

create table cliente (
agencia integer,
conta integer,
cpf varchar(14) not null,
nome varchar(20) not null,
nascimento date not null,
endereco varchar(30) not null,
telefone varchar(15),
saldo float not null,
senha varchar(10) not null,
primary key(agencia, conta)
);

create table contacorrente (
numero_doc integer primary key,
agencia integer not null,
conta integer not null,
valor float not null,
tipo enum('1','2','3'),
data_ocorrencia datetime default now(),
constraint fk_cc foreign key (agencia,conta) references cliente (agencia,conta)
);

insert into cliente values(100,34567,'123.456.788-92','Valdir de ALmeida','1975/03/28','Rua Avanhandava 234','(11)99123-4567',0,'abc@1234');
insert into cliente values(100,56789,'234.567.898-01','Rosana Prado','1988/10/05','Av. Pedroso 567','(11)99345-6789',0,'abc@1234');
insert into cliente values(200,12345,'456.789.018-90','Rodrigo Paiva','1991/05/09','Av. Interlagos 4567','(11)99890-1234',0,'abc@1234');
insert into cliente values(200,34567,'567.890.128-45','Jorge Carvalho','1977/07/17','Rua Jaburu 789','(11)99456-7890',0,'abc@1234');

select * from cliente;

-- insert into contacorrente values(12345,100,34567,500.00,1,now()); 

-- select * from contacorrente;
