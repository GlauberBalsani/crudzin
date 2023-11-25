ALTER TABLE livro ADD COLUMN autor_id BIGINT;
ALTER TABLE livro ADD FOREIGN KEY (autor_id) REFERENCES autor(autor_id);