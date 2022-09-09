package com.practica.fiestas.controller;

import com.practica.fiestas.model.Fiesta;
import com.practica.fiestas.model.Persona;
import com.practica.fiestas.repository.PersonaRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepo;

    @GetMapping("/traer")
    public ResponseEntity<Collection<Persona>> traerTodo() {
        return new ResponseEntity<>(personaRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Persona> traerUno(@PathVariable Long id) {
        Persona persona = personaRepo.findById(id).orElseThrow();

        if (persona != null) {
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarPersona(@RequestBody Persona persona) {
        return new ResponseEntity<>(personaRepo.save(persona), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/fiestas")
    public ResponseEntity<Collection<Fiesta>> ObtenerFiestas(@PathVariable Long id) {
        Persona persona = personaRepo.findById(id).orElseThrow();

        if (persona != null) {
            return new ResponseEntity<>(persona.getFiesta(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        personaRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
