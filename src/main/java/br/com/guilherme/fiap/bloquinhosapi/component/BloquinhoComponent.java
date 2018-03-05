package br.com.guilherme.fiap.bloquinhosapi.component;

import br.com.guilherme.fiap.bloquinhosapi.model.Bloquinho;
import br.com.guilherme.fiap.bloquinhosapi.repository.BloquinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BloquinhoComponent {

    @Autowired
    BloquinhoRepository bloquinhoRepository;

    public void save(Bloquinho bloquinho) {
        List<Bloquinho> bloquinhos = bloquinhoRepository.findByName(bloquinho.getName());
        if(!bloquinhos.isEmpty()) {
            bloquinho.setId(bloquinhos.get(0).getId());
        }
        bloquinhoRepository.save(bloquinho);
    }

    public Bloquinho findBloquinho(String name) {
        Bloquinho bloquinho;
        List<Bloquinho> bloquinhos = bloquinhoRepository.findByName(name);
        if(bloquinhos.isEmpty())
            return new Bloquinho();
        else
            return bloquinhos.get(0);
    }

    public List<Bloquinho> findAll() {
        return bloquinhoRepository.findAll();
    }

    public void erase(String name) {
        Bloquinho bloquinho;
        List<Bloquinho> bloquinhos = bloquinhoRepository.findByName(name);
        if(!bloquinhos.isEmpty())
            bloquinhoRepository.delete(bloquinhos.get(0));
    }

    public void eraseAll() {
        bloquinhoRepository.deleteAll();
    }
}
