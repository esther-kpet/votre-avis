package tg.otr.sentiments;

import org.junit.jupiter.api.Test;
import tg.otr.sentiments.entity.Client;
import tg.otr.sentiments.entity.Sentiment;
import tg.otr.sentiments.repository.ClientRepository;
import tg.otr.sentiments.repository.SentimentRepository;
import tg.otr.sentiments.service.ClientService;
import tg.otr.sentiments.service.SentimentService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class NpeReproductionTest {

    @Test
    public void testCreateSentimentWithNullClient() {
        ClientRepository clientRepository = mock(ClientRepository.class);
        SentimentRepository sentimentRepository = mock(SentimentRepository.class);
        ClientService clientService = new ClientService(clientRepository);
        SentimentService sentimentService = new SentimentService(clientService, sentimentRepository);

        Sentiment sentiment = new Sentiment();
        sentiment.setTexte("Excellent service");
        sentiment.setClient(null);

        assertThrows(IllegalArgumentException.class, () -> {
            sentimentService.create(sentiment);
        });
    }

    @Test
    public void testCreateSentimentWithClientNullEmail() {
        ClientRepository clientRepository = mock(ClientRepository.class);
        SentimentRepository sentimentRepository = mock(SentimentRepository.class);
        ClientService clientService = new ClientService(clientRepository);
        SentimentService sentimentService = new SentimentService(clientService, sentimentRepository);

        Sentiment sentiment = new Sentiment();
        sentiment.setTexte("Excellent service");
        sentiment.setClient(new Client());

        assertThrows(IllegalArgumentException.class, () -> {
            sentimentService.create(sentiment);
        });
    }
}
