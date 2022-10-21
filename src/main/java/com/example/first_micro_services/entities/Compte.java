package com.example.first_micro_services.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Compte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompte;

    private String login;
    private String password;
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "idclient")
    //@JsonIgnoreProperties("LesComptes")
    @JsonIgnore
    private Client client;

}
