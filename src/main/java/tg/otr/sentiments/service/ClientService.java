package tg.otr.sentiments.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import tg.otr.sentiments.entity.Client;
import tg.otr.sentiments.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ClientService {

    //I jst set this to be final
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client) {

        // Validation
        if (client == null || client.getEmail() == null || client.getEmail().isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email est obligatoire"
            );
        }

        // Vérification d’existence
        Client clientInDB = clientRepository.findByEmail(client.getEmail());
        if (clientInDB != null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Un client avec cet email existe déjà"
            );
        }

        // Sauvegarde (UNE SEULE FOIS)
        clientRepository.save(client);
    }

    public List<Client> research() {
        return this.clientRepository.findAll();
    }

    public Client read(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client clientToBeCreated){
        if (clientToBeCreated == null) {
            return null;
        }
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
