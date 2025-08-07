package Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity

public class Curtidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String texto;
    private Integer idPostagem;
    private Integer idAutor;


    @ManyToMany
    @JoinTable(
            name = "curtidasPostagens",
            joinColumns = @JoinColumn(name = "curtida_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private Set<Usuario> usuarios;
    
    @ManyToMany
    @JoinTable(
            name = "curtidas_postagens",
            joinColumns = @JoinColumn(name = "curtida_id"),
            inverseJoinColumns = @JoinColumn(name = "postagem_id")
    )
    private Set<Postagem> postagems = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Set<Postagem> getPostagems() {
        return postagems;
    }

    public void setPostagems(Set<Postagem> postagems) {
        this.postagems = postagems;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}





