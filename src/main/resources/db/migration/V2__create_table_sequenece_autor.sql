CREATE SEQUENCE autor_id_sequence START WITH 1 INCREMENT BY 1;


CREATE TABLE autor (
    autor_id BIGINT PRIMARY KEY DEFAULT nextval('autor_id_sequence'),
    nome VARCHAR(255),
    email VARCHAR(255)
);