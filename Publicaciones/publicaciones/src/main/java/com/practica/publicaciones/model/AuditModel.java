package com.practica.publicaciones.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"fechaCreacion", "fechaActualizacion"},
        allowGetters = true
)
@Getter @Setter
public abstract class AuditModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    @CreatedDate
    private Date fechaCreacion;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualizacion", nullable = false, updatable = false)
    @LastModifiedDate
    private Date fechaActualizacion;
}
