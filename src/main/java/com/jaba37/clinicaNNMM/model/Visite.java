package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "visite")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Visite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_visite")
    private Integer id_visite;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+02:00")
    @Column(name = "data_prenotazione")
    private Date data_prenotazione;

    @JoinColumn(name = "id_paziente")
    @ManyToOne
//    @JsonIgnoreProperties("visite")
    @JsonIgnore
    private Pazienti pazienti;

    @JoinColumn(name = "id_medico")
    @ManyToOne
//    @JsonIgnoreProperties("visite")
    @JsonIgnore
    private Medici medici;

    public Integer getId_visite() {
        return this.id_visite;
    }

//    public LocalDateTime getData_prenotazione() {
//        return this.data_prenotazione.toLocalDateTime();
//    }


    public ZonedDateTime getData_prenotazione() {
        return this.data_prenotazione.toInstant().atZone(ZoneId.of("GMT+02:00"));
    }

    public Pazienti getPazienti() {
        return this.pazienti;
    }

    public Medici getMedici() {
        return this.medici;
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