CREATE TABLE IF NOT EXISTS casas (
    codigo VARCHAR(7) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS casas_pessoas (
  codigo_casa VARCHAR(7) NOT NULL,
  email_pessoa VARCHAR(63) NOT NULL,
  CONSTRAINT casas_pessoas_pk PRIMARY KEY (codigo_casa, email_pessoa)
);