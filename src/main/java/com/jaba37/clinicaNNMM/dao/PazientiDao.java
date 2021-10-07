package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Pazienti;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PazientiDao {

    @Autowired
    private EntityManager entityManager;

    public List<Pazienti> getPazienti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Pazienti", Pazienti.class).getResultList();
    }

    public Pazienti getPazientiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Pazienti.class, id);
    }

    public void saveOrUpdatePazienti(List<Pazienti> Pazientis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Pazienti s : Pazientis) {
            currentSession.saveOrUpdate(s);
        }
    }

    public void deletePazienti(List<Pazienti> Pazientis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Pazienti s : Pazientis) {
            currentSession.delete(currentSession.find(Pazienti.class, s.getId_paziente()));
        }
    }

    public void deletePazientiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.delete(currentSession.find(Pazienti.class, id));
    }
}
