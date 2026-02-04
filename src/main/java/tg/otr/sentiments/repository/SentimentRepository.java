package tg.otr.sentiments.repository;

import tg.otr.sentiments.entity.Sentiment;
import tg.otr.sentiments.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository  extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
