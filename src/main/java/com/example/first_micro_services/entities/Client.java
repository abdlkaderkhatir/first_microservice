package com.example.first_micro_services.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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





}
