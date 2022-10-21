package com.example.first_micro_services.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "table_client")
@Data @AllArgsConstructor  @NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(nullable = false,length = 20)
    private String nom;


    @Column(unique = true)
    private String email;

    @Transient
    private int age;

    @Enumerated(EnumType.STRING)
    private Civility sexe;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    @Embedded
    private Adresse adresse;

    @JsonIgnore
    @OneToOne(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ClientDetails clientDetails;

    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Collection<Compte> lesComptes;

}
