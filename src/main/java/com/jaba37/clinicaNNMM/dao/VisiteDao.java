package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Visite;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VisiteDao {

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

    public List<Visite> getVisiteByUserId(Integer id){
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Visite WHERE pazienti.id_paziente = :id", Visite.class).setParameter("id", id).getResultList();
    }

//    public void saveOrUpdateVisite(List<Visite> Visites) {
//        Session currentSession = entityManager.unwrap(Session.class);
//        Session updateSession = entityManager.unwrap(Session.class);
//
//        for (Visite v : Visites) {
//            updateSession.saveOrUpdate(v);
//            currentSession.saveOrUpdate(v);
//        }
//    }

    public void saveOrUpdateVisite(Visite visita) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(visita);
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