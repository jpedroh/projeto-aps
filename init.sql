CREATE TABLE IF NOT EXISTS casas (
    codigo VARCHAR(7) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pessoas (
  email VARCHAR(63) PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  codigo_casa VARCHAR(7) NOT NULL,
  CONSTRAINT fk_casa FOREIGN KEY (codigo_casa) REFERENCES casas(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);
  
CREATE TABLE IF NOT EXISTS tarefas (
    id SERIAL PRIMARY KEY,
    nome varchar(255) NOT NULL ,
    codigo_casa VARCHAR(7) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    concluido BOOLEAN NULL,
    responsavel_email VARCHAR(63) NULL,
    parent_id bigint NULL,
    CONSTRAINT fk_casa FOREIGN KEY (codigo_casa) REFERENCES casas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_pessoa FOREIGN KEY (responsavel_email) REFERENCES pessoas(email) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_tarefa FOREIGN KEY (parent_id) REFERENCES tarefas(id) ON DELETE CASCADE ON UPDATE CASCADE
);
