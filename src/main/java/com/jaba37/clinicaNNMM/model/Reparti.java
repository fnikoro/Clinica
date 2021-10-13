package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;

@Entity
@Table(name = "reparti")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Reparti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reparto")
    private Integer id_reparto;

    @Column(name = "reparto")
    private String reparto;

    @JoinColumn(name = "id_reparto")
    @JsonIgnore
    @OneToOne
    private Medici medico;

    public Integer getId_reparto() {
        return this.id_reparto;
    }

    public String getReparto() {
        return this.reparto;
    }

    public Medici getMedico() {
        return this.medico;
    }

    public void setId_reparto(Integer id_reparto) {
        this.id_reparto = id_reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public void setMedico(Medici medico) {
        this.medico = medico;
    }
}