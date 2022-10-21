package com.example.first_micro_services.apis;

import com.example.first_micro_services.entities.Client;
import com.example.first_micro_services.entities.Compte;
import com.example.first_micro_services.repository.ClientRepository;
import com.example.first_micro_services.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("client-api")
public class APIController {


    @Autowired
    ClientRepository clientrepo;

    @Autowired
    CompteRepository compterepo;



    @GetMapping("/client/all") //GET http://localhost:8081/client-api/client/all
    public List<Client> getClients(){
        return clientrepo.findAll();
    }

    @GetMapping("/client/{id}") //GET http://localhost:8081/client-api/client/1
    public Client getClientById(@PathVariable("id") Long idClient){
        return clientrepo.findById(idClient).get();
    }

    @GetMapping("/client")  //GET http://localhost:8081/client-api/client?id=1
    public Client getClientById2(@RequestParam("id") Long idClient){
        return clientrepo.findById(idClient).get();
    }

    @PostMapping("/client")  //POST http://localhost:8081/client-api/client
    public Client createNewClient(@RequestBody Client client){
        return clientrepo.save(client);
    }

    @PostMapping("/compte") //POST http://localhost:8081/client-api/compte
    public Compte createNewCompte(@RequestBody Map<String,Object> payload){
        Compte c = new Compte();
        c.setLogin(payload.get("login").toString());
        c.setPassword(payload.get("password").toString());
        c.setDateCreation(new Date());

        Long idClient = Long.valueOf(payload.get("idClient").toString());
        c.setClient(clientrepo.findById(idClient).get());

        return compterepo.save(c);

    }

    @PutMapping("/client/{id}")  //Put http://localhost:8081/client-api/client/1
    public Client updateClient(@PathVariable(value = "id") Long idClient,
                               @RequestBody Client client) {
        if (clientrepo.findById(idClient).isPresent()) {
            client.setIdClient(idClient);
            return clientrepo.save(client);
        }
        return null;
    }

    @DeleteMapping("/client/{id}")   //Delete http://localhost:8081/client-api/client/1?

    public String DeleteClient(@PathVariable(value = "id") Long idClient){

        if (clientrepo.findById(idClient).isPresent()){
            clientrepo.deleteById(idClient);
            return "Correctly deleted";}
        return "the ID is not valid";
    }


}
