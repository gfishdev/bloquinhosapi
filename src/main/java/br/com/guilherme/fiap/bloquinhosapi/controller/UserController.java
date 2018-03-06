package br.com.guilherme.fiap.bloquinhosapi.controller;

import br.com.guilherme.fiap.bloquinhosapi.component.UserComponent;
import br.com.guilherme.fiap.bloquinhosapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    public UserComponent userComponent;

    @GetMapping("/username/{name}/{password}")
    public User findUser(@PathVariable(value = "name") String name, @PathVariable(value = "password") String password) {
        return userComponent.findUser(name, password);
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        user = userComponent.save(user);
        return user;
    }
}
