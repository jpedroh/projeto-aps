CREATE TABLE IF NOT EXISTS casas (
    codigo VARCHAR(7) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS pessoas (
  email VARCHAR(63) PRIMARY KEY,
  codigo_casa VARCHAR(7) NULL,
  CONSTRAINT fk_casas FOREIGN KEY(codigo_casa) REFERENCES casas(codigo) ON DELETE CASCADE ON UPDATE CASCADE
);