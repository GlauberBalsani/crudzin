package com.balsani.crudzin.domain.model.dto;

import com.balsani.crudzin.domain.model.Autor;
import com.balsani.crudzin.domain.model.Livro;

import java.util.List;

public class AutorResponse {
    private final Long id;
    private final String nome;
    private final String email;
    private final List<Livro> livros;

    public AutorResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.livros = autor.getLivros();
    }



    /**
     *
     * @return
     * os métodos getters sao importantes para serializar os objetos
     */

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    //    public AutorResponse toDTO(Autor autor) {
//        return new AutorResponse(autor.getId(),autor.getNome(),autor.getEmail());
//    }


    @Override
    public String toString() {
        return "AutorResponse{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", livros=" + livros +
                '}';
    }
}
