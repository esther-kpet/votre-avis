package estherkpetemey.com.sa;

import estherkpetemey.com.sa.controller.SentimentController;
import estherkpetemey.com.sa.service.SentimentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SentimentController.class)
public class ReproduceIssueTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SentimentService sentimentService;

    @Test
    public void testPostSentimentWithNullId() throws Exception {
        // This should fail if Sentiment.id is primitive 'int' and we send null or omit it
        mockMvc.perform(post("/sentiment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": null, \"texte\": \"Super\", \"type\": \"POSITIF\", \"client\": {\"email\": \"test@test.com\"}}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testPostSentimentWithoutId() throws Exception {
        // This should also fail if Sentiment.id is primitive 'int'
        mockMvc.perform(post("/sentiment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"texte\": \"Super\", \"type\": \"POSITIF\", \"client\": {\"email\": \"test@test.com\"}}"))
                .andExpect(status().isCreated());
    }
}
