
package com.practica.fiestas.repository;

import com.practica.fiestas.model.Fiesta;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiestaRepository extends CrudRepository<Fiesta, Long>{
    
    Collection<Fiesta> findAll();
}
