package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Entity
@Table(name = "medici")
public class Medici {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico")
    private Integer id_medico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "numero_cellulare")
    private String numero_cellulare;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    //ADDED
    @Transient
    private boolean[] disponibilita = new boolean[NUMERO_BLOCCHI_ORARI];

    //ADDED
    @Transient
    private List<String> listaOrari = new ArrayList<>();

    //ADDED
    @Transient
    private static final int NUMERO_BLOCCHI_ORARI = 18;

    //ADDED
    @Transient
    private static final String DATE_FORMATTER = "dd-MM-yyyy HH:mm";

    @OneToMany(mappedBy = "medici")
    private List<Visite> visitis;

    @JoinColumn(name = "id_reparto")
    @OneToOne
    private Reparti reparto;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNumero_cellulare(String numero_cellulare) {
        this.numero_cellulare = numero_cellulare;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //ADDED
    public void initializeDisponibilita() {
        for (int i = 0; i < getNumeroBlocchiOrari(); i++) {
            disponibilita[i] = true;
        }
    }

    //ADDED
    public void initializeListaOrariDisponibili() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        LocalDate today = LocalDate.now();
        LocalDate startOfBooking = today.plusDays(7);
        LocalDate endOfBooking = LocalDate.of(2021, Month.NOVEMBER, 30);
        int daysBetween = (int) ChronoUnit.DAYS.between(startOfBooking, endOfBooking);

        LocalDateTime dataOra = startOfBooking.atTime(8, 0);
        String formatDateTime = "";


        for (int i = 0; i <= daysBetween; i++) {
            for (int k = 0; k < NUMERO_BLOCCHI_ORARI; k++) {

                if(dataOra.getDayOfWeek() == DayOfWeek.SUNDAY){
                    dataOra = dataOra.plusDays(1);
                    dataOra = dataOra.withHour(8);
                    dataOra = dataOra.withMinute(0);
                    break;
                }

                if ((dataOra.getHour() == 13) && (dataOra.getMinute() == 0)) {
                    dataOra = dataOra.plusHours(1);
                }

                formatDateTime = dataOra.format(formatter);
                listaOrari.add(formatDateTime);
                dataOra = dataOra.plusMinutes(30);

                if ((dataOra.getHour() == 18) && (dataOra.getMinute() == 0)) {
                    dataOra = dataOra.plusDays(1);
                    dataOra = dataOra.withHour(8);
                    dataOra = dataOra.withMinute(0);
                }
            }
        }
    }

    public Integer getId_medico() {
        return this.id_medico;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getNumero_cellulare() {
        return this.numero_cellulare;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    //ADDED
    public boolean[] getDisponibilita() {
        return disponibilita;
    }

    //ADDED
    public static int getNumeroBlocchiOrari() {
        return NUMERO_BLOCCHI_ORARI;
    }

    //ADDED
    public List<String> getListaOrari() {
        return listaOrari;
    }
}