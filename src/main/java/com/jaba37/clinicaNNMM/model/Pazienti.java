package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pazienti", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Pazienti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paziente")
    private Integer id_paziente;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name = "indirizzo", nullable = false, length = 50)
    private String indirizzo;

    @Column(name = "localita", nullable = false, length = 50)
    private String localita;

    @Column(name = "cap", nullable = false, length = 5)
    private String cap;

    @Column(name = "numero_cellulare", nullable = false, length = 15)
    private String numero_cellulare;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @OneToMany(mappedBy = "pazienti")
    private List<Visite> visitis;



    public Integer getId_paziente() {
        return id_paziente;
    }

    public void setId_paziente(Integer id_paziente) {
        this.id_paziente = id_paziente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getLocalita() {
        return localita;
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getNumero_cellulare() {
        return numero_cellulare;
    }

    public void setNumero_cellulare(String numero_cellulare) {
        this.numero_cellulare = numero_cellulare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Visite> getVisitis() {
        return visitis;
    }

    public void setVisitis(List<Visite> visitis) {
        this.visitis = visitis;
    }
}
