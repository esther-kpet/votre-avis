//package tg.otr.sentiments;
//
//import tg.otr.sentiments.entity.Client;
//import tg.otr.sentiments.repository.ClientRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class ClientIntegrationTest {
////
////    @Autowired
////    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private ClientRepository clientRepository;
//
//    @Test
//    void testCreerClient() {
//        Client client = new Client();
//        client.setEmail("postman@test.com");
//
////        ResponseEntity<Void> response = restTemplate.postForEntity("/client", client, Void.class);
//
////        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//        boolean exists = clientRepository.findAll().stream()
//                .anyMatch(c -> "postman@test.com".equals(c.getEmail()));
//
//        assertTrue(exists, "Le client devrait être présent dans la base de données");
//    }
//}
