package com.example.first_micro_services.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="pr1", types=Client.class)
public interface ClientProjection {

    public Long getIdClient();

    @Value("#{target.clientDetails.description}")
    public String getDescription();

    @Value("#{target.adresse.ville}")
    public String getCity();
}
