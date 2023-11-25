package com.balsani.crudzin.domain.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_id_sequence")
    @SequenceGenerator(name = "autor_id_sequence", sequenceName = "autor_id_sequence", allocationSize = 1)
    @Column(name = "autor_id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private List<Livro> livros;

    @Deprecated
    public Autor() {
    }

    public Autor(String nome, String email) {
        this.nome = nome;
        this.email = email;

    }

    public Autor(String nome, String email,List<Livro> livros) {
        this.nome = nome;
        this.email = email;
        this.livros = livros;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
