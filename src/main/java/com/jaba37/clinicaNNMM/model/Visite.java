package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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

    public Integer getMediciId() {
        return this.medici.getId_medico();
    }

    public void setId_visite(Integer id_visite) {
        this.id_visite = id_visite;
    }

    public void setData_prenotazione(Timestamp data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
    }

    public void setPazienti(Pazienti pazienti) {
        this.pazienti = pazienti;
    }

    public void setMedici(Medici medici) {
        this.medici = medici;
    }
}