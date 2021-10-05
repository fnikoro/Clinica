package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Reparti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RepartiDao {

    @Autowired
    private EntityManager entityManager;

    public List<Reparti> getReparti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Reparti", Reparti.class).getResultList();
    }

    public Reparti getRepartiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Reparti d = currentSession.find(Reparti.class, id);
        return d;
    }

    public void saveOrUpdateReparti(List<Reparti> Repartis) {
        Session currentSession = entityManager.unwrap(Session.class);
        Session updateSession = entityManager.unwrap(Session.class);
        for (Reparti r : Repartis) {
            currentSession.saveOrUpdate(r);
            updateSession.saveOrUpdate(r);
        }
    }

    public void deleteReparti(List<Reparti> Repartis) {
        Session currentSession = entityManager.unwrap(Session.class);
        for (Reparti r : Repartis) {
            currentSession.delete(currentSession.find(Reparti.class, r.getId_reparto()));
        }
    }

    public void deleteRepartiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.delete(currentSession.find(Reparti.class, id));
    }
}
