package com.balsani.crudzin.domain.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_id_sequence")
    @SequenceGenerator(name = "livro_id_sequence", sequenceName = "livro_id_sequence", allocationSize = 1)
    @Column(name = "livro_id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "isbn")
    private String isbn;

    @Deprecated
    public Livro(){

    }

    public Livro(String nome, String isbn) {
        this.nome = nome;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
