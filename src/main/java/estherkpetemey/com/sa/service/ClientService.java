package estherkpetemey.com.sa.service;

import estherkpetemey.com.sa.entities.Client;
import estherkpetemey.com.sa.repository.ClientRepository;
import org.springframework.stereotype.Service;


@Service
public class ClientService {


    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void creer(Client client) {
        this.clientRepository.save(client);

    }
}
