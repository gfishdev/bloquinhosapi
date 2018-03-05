package br.com.guilherme.fiap.bloquinhosapi.component;

import br.com.guilherme.fiap.bloquinhosapi.model.User;
import br.com.guilherme.fiap.bloquinhosapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserComponent {

    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        List<User> users = userRepository.findByName(user.getUsername());
        if (!users.isEmpty()) {
            user.setId(users.get(0).getId());
        }
        userRepository.save(user);
    }

    public void inactive(String name) {
        User user;
        List<User> users = userRepository.findByName(name);
        if (!users.isEmpty()) {
            user = users.get(0);
            user.setActive(false);
            userRepository.save(user);
        }
    }
}
