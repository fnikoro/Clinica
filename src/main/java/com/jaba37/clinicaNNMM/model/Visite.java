package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visite")
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_visite")
    private Integer id_visite;
                        //timestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "data_prenotazione")
    private Date data_prenotazione;

    @JoinColumn(name = "id_paziente")
    @ManyToOne
    @JsonIgnoreProperties("visite")
    private Pazienti pazienti;

    @JoinColumn(name = "id_medico")
    @ManyToOne
    @JsonIgnoreProperties("visite")
    private Medici medici;

    public Integer getId_visite() {
        return id_visite;
    }

    public Date getData_prenotazione() {
        return data_prenotazione;
    }

    public Pazienti getPazienti() {
        return pazienti;
    }

    public Medici getMedici() {
        return medici;
    }
}