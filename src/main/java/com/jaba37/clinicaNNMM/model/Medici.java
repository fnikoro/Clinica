package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medici")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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

    
    @Transient
    public static final int NUMERO_BLOCCHI_ORARI = 18;

    
    @Transient
    public static final int NUMERO_GIORNI = 30;

    
    @Transient
    private Object[][] disponibilita = new Object[NUMERO_GIORNI][NUMERO_BLOCCHI_ORARI];

    
    @Transient
    private List<String> listaOrari = new ArrayList<>();

    
    @Transient
    private final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
//    private final String DATE_FORMATTER = "dd-MM-yyyy HH:mm:ss";

    @OneToMany(mappedBy = "medici")
    private List<Visite> visitis;

    @JoinColumn(name = "id_reparto")
    @OneToOne
    private Reparti reparto;

    
    public void setDisponibilitaAtIndexInDayJ(Integer j, Integer index, boolean value) {
        this.disponibilita[j][index] = value;
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

    public Object[][] getDisponibilita() {
        return this.disponibilita;
    }

    
    public boolean getDisponibilitaAtIndexInDayJ(Integer j, Integer index) {
        return (boolean) this.disponibilita[j][index];
    }

    
    public List<String> getListaOrari() {
        return this.listaOrari;
    }

    public String getListaOrariAtIndex (Integer index){
        return this.listaOrari.get(index);
    }

    
    public String getDateFormatter() {
        return this.DATE_FORMATTER;
    }

    public Reparti getReparto() {
        return this.reparto;
    }

    
    public boolean add(String orario) {
        return this.listaOrari.add(orario);
    }

    public void setId_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

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

    public void setDisponibilita(Object[][] disponibilita) {
        this.disponibilita = disponibilita;
    }

    public void setListaOrari(List<String> listaOrari) {
        this.listaOrari = listaOrari;
    }

    public void setVisitis(List<Visite> visitis) {
        this.visitis = visitis;
    }

    public void setReparto(Reparti reparto) {
        this.reparto = reparto;
    }
}