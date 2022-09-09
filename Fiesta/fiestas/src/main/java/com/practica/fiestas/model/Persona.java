package com.practica.fiestas.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "persona_id")
    private Long id;
    private String nombre;
    private int edad;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
    private Set<Habilidad> habilidades = new HashSet<>();

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "personas_fiestas", joinColumns = @JoinColumn(name = "persona_id", referencedColumnName = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "fiesta_id", referencedColumnName = "fiesta_id"))
    private Set<Fiesta> fiesta = new HashSet<>();

}
