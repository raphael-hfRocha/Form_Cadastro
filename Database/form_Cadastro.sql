CREATE DATABASE form_Cadastro;
USE form_Cadastro;

CREATE TABLE Cadastro(
id_user INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nome VARCHAR(45) NOT NULL,
sobrenome VARCHAR(45) NOT NULL,
email VARCHAR(45),
senha VARCHAR(45));