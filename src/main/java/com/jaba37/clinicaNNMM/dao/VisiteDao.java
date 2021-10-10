package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Visite;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisiteDao {

//  ----------------------------------- prenotazione
//  visualizzazione reparto
//  scelta reparto, bloccando l'id
//  scelta data, visualizzazione orari disponibili (mostrare orari disponibili)
//  mostrare medici disponibili (pensare al discorso di cosa succede se un reparto viene cambiato) / dare possibilità di cambiaer orario etc
//  aggiungere visita e occupare blocco orario corrispondente a medico
//  setuppare metodo per inviare mail

//  ----------------------------------- cancellazione
//  visualizzare visite legate all'utente
//  scelta prenotazione da eliminare con conferma
//  invio email a paziente e medico
//  cancellare visita, liberare blocco orario a medico

    @Autowired
    private EntityManager entityManager;

    public List<Visite> getVisite() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Visite", Visite.class).getResultList();
    }

    public Visite getVisiteById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Visite v = currentSession.find(Visite.class, id);
        return v;
    }

    public void saveOrUpdateVisite(List<Visite> Visites) {
        Session currentSession = entityManager.unwrap(Session.class);
        Session updateSession = entityManager.unwrap(Session.class);

        for (Visite v : Visites) {
            updateSession.saveOrUpdate(v);
            currentSession.saveOrUpdate(v);
        }
    }

    public void deleteVisite(List<Visite> Visites) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Visite v : Visites) {
            currentSession.delete(currentSession.find(Visite.class, v.getId_visite()));
        }
    }

    public void deleteVisiteById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Visite.class, id));
    }
}
