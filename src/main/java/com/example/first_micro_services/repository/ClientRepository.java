package com.example.first_micro_services.repository;

import com.example.first_micro_services.entities.Civility;
import com.example.first_micro_services.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Date;
import java.util.List;





@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findClientsByNom(String nom);
    List<Client> findClientsByNomAndSexe(String n, Civility s);
    List<Client> findClientsByNomIsLike(String n);
    List<Client> findClientsByDateNaissanceAfter(Date d) ;
    boolean existsByEmailContaining(String e);
}