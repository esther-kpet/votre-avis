package estherkpetemey.com.sa;

import estherkpetemey.com.sa.controller.SentimentController;
import estherkpetemey.com.sa.service.SentimentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SentimentController.class)
public class Sentiment405Test {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SentimentService sentimentService;

    @Test
    public void testPostSentimentCorrectPath() throws Exception {
        // The context path is NOT automatically applied in @WebMvcTest for MockMvc 
        // unless you use a different setup or it's an integration test.
        // However, the issue might be that the user is NOT using the context path in their real environment.
        
        mockMvc.perform(post("/sentiment")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"texte\": \"Super\", \"type\": \"POSITIF\", \"client\": {\"email\": \"test@test.com\"}}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetSentimentIncorrectMethod() throws Exception {
        // This should return 405 because only POST is defined for /sentiment
        mockMvc.perform(get("/sentiment"))
                .andExpect(status().isMethodNotAllowed());
    }
}
