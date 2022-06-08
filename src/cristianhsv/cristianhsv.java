//create database cristianhsv;
//use cristianhsv;
//create table medico (
//	id int primary key auto_increment,
//    nome varchar(255) not null,
//    crm int not null,
//    cpf varchar(255) not null,
//    especialidade int not null
//);
//create table paciente (
//	id int primary key auto_increment,
//	cpf varchar(255) not null,
//	idade int not null,
//	nome varchar(255) not null
//);
//create table consulta (
//	convenio varchar(255) not null,
//	id int primary key auto_increment,
//    idmedico int not null,
//    idpaciente int not null,
//    foreign key (idmedico) references medico(id) on delete cascade on update cascade,
//    foreign key (idpaciente) references paciente(id) on delete cascade on update cascade
//);