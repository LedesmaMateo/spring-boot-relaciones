
package com.practica.fiestas.repository;

import com.practica.fiestas.model.Persona;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    Collection<Persona> findAll();
}
