package com.balsani.crudzin.domain.model.dto;

import com.balsani.crudzin.domain.model.Livro;

public class LivroRequest {
    private final String nome;
    private final String isbn;

    public LivroRequest(String nome, String isbn) {
        this.nome = nome;
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public Livro toModel() {
        return new Livro(nome, isbn);
    }
}
