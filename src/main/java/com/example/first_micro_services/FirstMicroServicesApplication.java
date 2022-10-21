package com.example.first_micro_services;

import com.example.first_micro_services.entities.*;
import com.example.first_micro_services.repository.ClientDetailsRepository;
import com.example.first_micro_services.repository.ClientRepository;
import com.example.first_micro_services.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class FirstMicroServicesApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientrepo;

    @Autowired
    ClientDetailsRepository clientdetailsrepo;

    @Autowired
    CompteRepository compterepo;

    public static void main(String[] args) {
        SpringApplication.run(FirstMicroServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

            clientrepo.save(new Client(null, "Abdelkader_khatir", "a.khatir@esi-sba.dz", 22, Civility.Homme, Date.valueOf("2000-03-22"), new Adresse("adda", 52, "22000", "sidi bel abbes"), null, null));
            clientrepo.save(new Client(null, "aboubaker khatir", "b.khatr@gmail.com", 18, Civility.Homme, Date.valueOf("2000-05-23"), null, null, null));

            Client client = clientrepo.findById(1L).get();
            Client client2 = clientrepo.findById(2L).get();


            // client.setNom("Abdelhamid");
            client2.setAdresse(new Adresse("abba", 52, "22046", "temouchent"));

            clientdetailsrepo.save(new ClientDetails(null, "Software Devloper", client));

            compterepo.save(new Compte(null, "abdelkader", "khatir", null, client));


    }
}
