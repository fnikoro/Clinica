package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "visite")
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_visite")
    private Integer id_visite;

    @Column(name = "data_prenotazione")
    private Timestamp data_prenotazione;

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

    public LocalDateTime getData_prenotazione() {
        return data_prenotazione.toLocalDateTime();
    }

    public Pazienti getPazienti() {
        return pazienti;
    }

    public Medici getMedici() {
        return medici;
    }
}