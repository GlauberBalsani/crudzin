package com.balsani.crudzin.domain.model.dto;

import com.balsani.crudzin.domain.model.Autor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AutorRequest {
    @NotEmpty
    @Size(max = 120)
    private final String nome;
    @NotEmpty
    @Email
    @Size(max = 60)
    private final String email;

    public AutorRequest(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Autor toModel() {
        return new Autor(nome, email);
    }

    @Override
    public String toString() {
        return "AutorRequest{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
