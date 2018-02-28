package br.com.guilherme.fiap.bloquinhosapi.controller;

import br.com.guilherme.fiap.bloquinhosapi.BloquinhoComponent;
import br.com.guilherme.fiap.bloquinhosapi.model.Bloquinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "bloquinho")
public class BloquinhoController {

    @Autowired
    public BloquinhoComponent bloquinhoComponent;

    @GetMapping("/name/{name}")
    public Bloquinho findBloquinho(@PathVariable(value = "name") String name) {
        return bloquinhoComponent.findBloquinho(name);
    }

    @GetMapping()
    public List<Bloquinho> findAll() {
        return bloquinhoComponent.findAll();
    }

    @DeleteMapping("/name/{name}")
    public void erase(@PathVariable(value = "name") String name) {
        bloquinhoComponent.erase(name);
    }

    @DeleteMapping()
    public void eraseAll() {
        bloquinhoComponent.eraseAll();
    }

    @PostMapping()
    public Bloquinho save(@RequestBody Bloquinho bloquinho) {
        bloquinhoComponent.save(bloquinho);
        return bloquinho;
    }
}
