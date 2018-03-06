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

    public User save(User user) {
        List<User> users = userRepository.findByUsername(user.getUsername(), user.getPassword());
        if (!users.isEmpty()) {
            user.setId(users.get(0).getId());
        }
        user.setActive(true);
        userRepository.save(user);
        return user;
    }

    // TODO: Encontrar a maneira mais segura de fazer o login e retornar o usuario sem senha
    public User findUser(String username, String password) {
        User user;
        List<User> users = userRepository.findByUsername(username, password);
        if (users.isEmpty())
            return new User();
        else {
            user = users.get(0);
            return user;
        }
    }

    public void inactive(String username, String password) {
        User user;
        List<User> users = userRepository.findByUsername(username, password);
        if (!users.isEmpty()) {
            user = users.get(0);
            user.setActive(false);
            userRepository.save(user);
        }
    }
}
