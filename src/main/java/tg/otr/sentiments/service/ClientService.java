package tg.otr.sentiments.service;

import tg.otr.sentiments.entity.Client;
import tg.otr.sentiments.repository.ClientRepository;
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

    public void create(Client client) {
        Client clientInDB = this.clientRepository.findByEmail(client.getEmail());
        if(clientInDB == null){
            this.clientRepository.save(client);
        }

    }

    public List<Client> research() {
        return this.clientRepository.findAll();
    }

    public Client read(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client clientToBeCreated){
        Client clientInDB = this.clientRepository.findByEmail(clientToBeCreated.getEmail());
        if(clientInDB == null){
            clientInDB = this.clientRepository.save(clientToBeCreated);
        }
        return clientInDB;
    }

    public void modify(Integer id, Client client) {
        Client clientInDB = this.read(id);
        if(Objects.equals(clientInDB.getId(), client.getId())){
            clientInDB.setEmail(client.getEmail());
            clientInDB.setTelephone(client.getTelephone());
            this.clientRepository.save(clientInDB);
        }
    }

}
