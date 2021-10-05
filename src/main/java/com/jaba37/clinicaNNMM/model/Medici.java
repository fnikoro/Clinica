package com.jaba37.clinicaNNMM.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medici")
public class Medici {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_medico")
    private Integer id_medico;

    @Column(name = "nome")
    private String nome_;

    @Column(name = "cognome")
    private String cognome;

    @Column(name = "numero_cellulare")
    private String numero_cellulare;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "medici")
    private List<Visite> visitis;

    @JoinColumn(name = "id_reparto")
    @OneToOne
    private Reparti reparto;

    public Integer getId_medico() {
        return id_medico;
    }


}
