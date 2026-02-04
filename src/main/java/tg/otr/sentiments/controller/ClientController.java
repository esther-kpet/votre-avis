package tg.otr.sentiments.controller;

import tg.otr.sentiments.entity.Client;
import tg.otr.sentiments.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= "clients")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client) {
        this.clientService.create(client);

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> research() {
        return this.clientService.research();
    }

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client read(@PathVariable Integer id) {
        return this.clientService.read(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path="{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable Integer id, @RequestBody Client client){
        this.clientService.modify(id, client);

    }
}
