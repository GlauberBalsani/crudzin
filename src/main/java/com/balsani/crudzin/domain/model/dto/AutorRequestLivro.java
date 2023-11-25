package com.balsani.crudzin.domain.model.dto;

import com.balsani.crudzin.domain.model.Autor;
import com.balsani.crudzin.domain.model.Livro;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.stream.Collectors;

public class AutorRequestLivro {
    @NotEmpty
    @Size(max = 120)
    private final String nome;
    @NotEmpty
    @Email
    @Size(max = 60)
    private final String email;

    private List<LivroRequest> livros;

    public AutorRequestLivro(String nome, String email, List<LivroRequest> livros) {
        this.nome = nome;
        this.email = email;
        this.livros = livros;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<LivroRequest> getLivros() {
        return livros;
    }

    public Autor toModel() {
        List<Livro> livrosDoAutor = livros.stream().map((i) -> {
            return i.toModel();
        }).collect(Collectors.toList());

        return new Autor(nome, email, livrosDoAutor);
    }
}
