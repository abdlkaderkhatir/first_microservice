package com.example.first_micro_services.repository;

import com.example.first_micro_services.entities.ClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Long> {
}