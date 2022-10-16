package com.example.first_micro_services;

import com.example.first_micro_services.entities.Client;
import com.example.first_micro_services.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstMicroServicesApplication implements CommandLineRunner {
    @Autowired
    ClientRepository clientrepo;

    public static void main(String[] args) {

        SpringApplication.run(FirstMicroServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
            clientrepo.save(new Client(null,"Abdelkader_khatir","a.khatir@esi-sba.dz",22));
            clientrepo.save(new Client(null,"aboubaker khatir","b.khatr@gmail.com",18));
    }
}
