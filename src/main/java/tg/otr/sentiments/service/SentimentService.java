package tg.otr.sentiments.service;

import tg.otr.sentiments.entity.Client;
import tg.otr.sentiments.entity.Sentiment;
import tg.otr.sentiments.enums.TypeSentiment;
import tg.otr.sentiments.repository.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment){
        Client client = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);

        //Analyse
        sentiment.setType(TypeSentiment.POSITIF);
        if (sentiment.getTexte().contains("pas")){
            sentiment.setType(TypeSentiment.NEGATIF);
        }
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> research(TypeSentiment type) {
        if(type == null){
            return this.sentimentRepository.findAll();
        } else {
            return this.sentimentRepository.findByType(type);
        }
    }

    public void delete(Integer id) {
        this.sentimentRepository.deleteById(id);
    }
}
