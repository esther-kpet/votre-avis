package tg.otr.sentiments.controller;

import tg.otr.sentiments.entity.Sentiment;
import tg.otr.sentiments.enums.TypeSentiment;
import tg.otr.sentiments.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create (@RequestBody Sentiment sentiment) {
        this.sentimentService.create(sentiment);

    }

    @GetMapping
    public @ResponseBody List<Sentiment> research(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.research(type);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path= "{id}")
    public void delete (@PathVariable Integer id) {
        this.sentimentService.delete(id);

    }
}
