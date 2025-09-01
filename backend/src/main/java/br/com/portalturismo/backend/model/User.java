package br.com.portalturismo.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "usuarios")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nome")
    private String nome;

    @Column(name="email")
    private String email;

    @Column(name="senha")
    private String senha;

}
