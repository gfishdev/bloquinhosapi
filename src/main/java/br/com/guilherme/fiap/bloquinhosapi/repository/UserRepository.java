package br.com.guilherme.fiap.bloquinhosapi.repository;

import br.com.guilherme.fiap.bloquinhosapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByName(String name, String password);
}
