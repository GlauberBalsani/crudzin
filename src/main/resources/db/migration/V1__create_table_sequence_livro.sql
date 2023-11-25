CREATE SEQUENCE livro_id_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE livro(
    livro_id BIGINT PRIMARY KEY DEFAULT nextval('livro_id_sequence'),
    nome VARCHAR(255),
    isbn VARCHAR(255)
)