package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pazienti")
public class Pazienti {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_paziente")
    private Integer id_paziente;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "indirizzo")
    private String indirizzo;

    @Column(name = "localita")
    private String localita;

    @Column(name = "cap")
    private String cap;

    @Column(name = "numero_cellulare")
    private String numero_cellulare;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "pazienti")
    private List<Visite> visitis;

    public Integer getId_paziente() {
        return id_paziente;
    }


}
