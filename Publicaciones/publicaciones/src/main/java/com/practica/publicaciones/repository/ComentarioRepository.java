
package com.practica.publicaciones.repository;

import com.practica.publicaciones.model.Comentario;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    
    Page<Comentario> findByPublicacionId(Long publicacionId, Pageable pageable);
    
    Optional<Comentario> findByIdAndPublicacionId(Long comentarioId, Long publicacionId);
    
}
