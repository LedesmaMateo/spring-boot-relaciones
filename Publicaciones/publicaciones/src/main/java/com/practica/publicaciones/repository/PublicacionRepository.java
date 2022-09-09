package com.practica.publicaciones.repository;

import com.practica.publicaciones.model.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long>{
    
}
