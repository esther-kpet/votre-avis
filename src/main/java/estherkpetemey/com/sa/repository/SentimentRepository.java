package estherkpetemey.com.sa.repository;

import estherkpetemey.com.sa.entities.Sentiment;
import estherkpetemey.com.sa.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository  extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentiment type);
}
