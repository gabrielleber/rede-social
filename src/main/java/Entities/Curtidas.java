package Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Curtidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String texto;
    private Integer idPostagem;
    private Integer idAutor;

    @ManyToMany
}
