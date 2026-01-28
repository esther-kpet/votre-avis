package estherkpetemey.com.sa.repository;

import estherkpetemey.com.sa.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
