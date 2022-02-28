create database emprestimo;
use emprestimo;
create table cadastro (
nome		varchar(50) not null,
email		varchar(50) not null,
cpf			varchar(11) not null,
rg			varchar(11) not null,
endereco	varchar(50) not null,
complemento varchar(20),
bairro		varchar(20) not null,
cidade		varchar(20) not null,
uf			varchar(2)  not null,
cep			varchar(8)  not null,
renda		float		not null,
senha		varchar(30) not null);
ALTER TABLE cadastro
ADD CONSTRAINT PK_CLIENTES
PRIMARY KEY (email);

create table login(
email		varchar(50)	not null,
senha		varchar(30) not null);
ALTER TABLE login
ADD CONSTRAINT PK_LOGIN
PRIMARY KEY (email);


create table emprestimo(
codigo				int auto_increment,
email				varchar(50),
valorEmprestimo		float,
dataInicio			date,
numParcelas			int(3));
ALTER TABLE emprestimo
ADD CONSTRAINT PK_CODIGO
PRIMARY KEY (codigo);

ALTER TABLE emprestimo
ADD CONSTRAINT FK_EMAIL 
FOREIGN KEY (email);
