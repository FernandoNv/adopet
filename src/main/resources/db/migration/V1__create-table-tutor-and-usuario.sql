CREATE TABLE tutores(
    id BIGSERIAL NOT NULL,
    foto text,
    nome VARCHAR(100) NOT NULL,
    telefone varchar(20),
    cidade varchar(100),
    sobre text,
    CONSTRAINT tutores_id_pkey PRIMARY KEY(id)
);

CREATE TABLE usuarios(
  id BIGSERIAL NOT NULL,
  email varchar(100) NOT NULL,
  senha varchar(100) NOT NULL,
  CONSTRAINT usuarios_id_pkey PRIMARY KEY(id)
);