
package com.practica.publicaciones.controller;

import com.practica.publicaciones.exception.ResourceNotFoundException;
import com.practica.publicaciones.model.Publicacion;
import com.practica.publicaciones.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicacionController {
    
    @Autowired
    private PublicacionRepository publicacionRepository;
    
    @GetMapping("/publicacion")
    public Page<Publicacion> listarPublicaciones(Pageable pageable){
        return publicacionRepository.findAll(pageable);
    }
    
    @PostMapping("/publicacion/guardar")
    public Publicacion guardarPublicacion(@RequestBody Publicacion publicacion){
        return publicacionRepository.save(publicacion);
    }
    
    @PutMapping("/publicacion/{publicacionId}")
    public Publicacion actualizarPublicacion(@PathVariable Long publicacionId,
                                             @RequestBody Publicacion publicacionReq){
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            publicacion.setTitulo(publicacionReq.getTitulo());
            publicacion.setDescripcion(publicacionReq.getDescripcion());
            publicacion.setContenido(publicacionReq.getContenido());
            return publicacionRepository.save(publicacion);
        }).orElseThrow(() -> new ResourceNotFoundException("Publicacion con el ID: " + publicacionId + " no encontrada"));
    }
    
    @DeleteMapping("/publicacion/borrar/{publicacionId}")
    public ResponseEntity<?> eliminarPublicacion(@PathVariable Long publicacionId){
        return publicacionRepository.findById(publicacionId).map(publicacion -> {
            publicacionRepository.delete(publicacion);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Publicacion con el ID: " + publicacionId + " no encontrada"));
    }
}
