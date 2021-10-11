package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "reparti")
public class Reparti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reparto")
    private Integer id_reparto;

    @Column(name = "reparto")
    private String reparto;

    @JoinColumn(name = "id_reparto")
    @JsonIgnoreProperties("reparti")
    @OneToOne
    private Medici medico;

    public Integer getId_reparto() {
        return id_reparto;
    }
}