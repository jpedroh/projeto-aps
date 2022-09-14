CREATE TABLE IF NOT EXISTS tarefas (
    id SERIAL PRIMARY KEY,
    nome varchar(255) NOT NULL ,
    codigo_casa VARCHAR(7) NOT NULL,
    date_time TIMESTAMP NOT NULL,
    concluido BOOLEAN NULL,
    responsavel_email VARCHAR(63) NULL,
    parent_id bigint NULL,
    CONSTRAINT fk_tarefa FOREIGN KEY (parent_id) REFERENCES tarefas(id) ON DELETE CASCADE ON UPDATE CASCADE
);
