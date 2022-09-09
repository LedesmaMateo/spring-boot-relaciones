package com.practica.fiestas.controller;

import com.practica.fiestas.model.Fiesta;
import com.practica.fiestas.repository.FiestaRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fiesta")
public class FiestaController {

    @Autowired
    private FiestaRepository fiestaRepo;

    @GetMapping("/traer")
    public ResponseEntity<Collection<Fiesta>> traerTodo() {
        return new ResponseEntity<>(fiestaRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Fiesta> traerUno(@PathVariable Long id) {
        Fiesta fiesta = fiestaRepo.findById(id).orElseThrow();

        if (fiesta != null) {
            return new ResponseEntity<>(fiestaRepo.findById(id).orElseThrow(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarFiesta(@RequestBody Fiesta fiesta) {
        return new ResponseEntity<>(fiestaRepo.save(fiesta), HttpStatus.CREATED);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<Void> borrarFiesta(@PathVariable Long id) {
        fiestaRepo.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
