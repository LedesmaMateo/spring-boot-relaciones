package com.practica.fiestas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "fiestas")
public class Fiesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fiesta_id")
    private Long id;

    private String ubicacion;

    @Column(name = "fiesta_fecha")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date fecha;

    @ManyToMany
    @JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"),
            inverseJoinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"))
    private Set<Persona> persona = new HashSet<>();

}
