package com.example.first_micro_services.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "table_client")
@Data @AllArgsConstructor  @NoArgsConstructor
public class Client  implements Serializable {
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

    @OneToOne(mappedBy = "client",fetch = FetchType.EAGER)
    private ClientDetails clientDetails;


    //@JsonManagedReference
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //@JsonIgnoreProperties("client")
    private List<Compte> LesComptes;

}
