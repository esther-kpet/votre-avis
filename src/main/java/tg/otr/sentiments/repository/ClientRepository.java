package tg.otr.sentiments.repository;

import tg.otr.sentiments.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);
}
