package br.com.guilherme.fiap.bloquinhosapi.repository;

import br.com.guilherme.fiap.bloquinhosapi.model.Bloquinho;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BloquinhoRepository extends MongoRepository<Bloquinho, String> {
    List<Bloquinho> findByName(String name);
}
