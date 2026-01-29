package estherkpetemey.com.sa.service;

import estherkpetemey.com.sa.entities.Client;
import estherkpetemey.com.sa.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ClientService {


    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if(clientDansLaBDD == null){
            this.clientRepository.save(client);
        }

    }

    public List<Client> rechercher() {
        return this.clientRepository.findAll();
    }

    public Client lire(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientACreer){
        Client clientDansLaBDD = this.clientRepository.findByEmail(clientACreer.getEmail());
        if(clientDansLaBDD == null){
            clientDansLaBDD = this.clientRepository.save(clientACreer);
        }
        return clientDansLaBDD;
    }

    public void modifier(Integer id, Client client) {
        Client clientDansLaBDD = this.lire(id);
        if(Objects.equals(clientDansLaBDD.getId(), client.getId())){
            clientDansLaBDD.setEmail(client.getEmail());
            clientDansLaBDD.setTelephone(client.getTelephone());
            this.clientRepository.save(clientDansLaBDD);
        }
    }
}
