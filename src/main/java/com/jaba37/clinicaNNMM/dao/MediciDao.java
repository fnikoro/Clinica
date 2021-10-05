package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Medici;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MediciDao {

    @Autowired
    private EntityManager entityManager;

    public List<Medici> getMedici() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Medici", Medici.class).getResultList();
    }

    public Medici getMediciById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Medici.class, id);
    }

    public void saveOrUpdateMedici(List<Medici> Medicis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Medici s : Medicis) {
            currentSession.saveOrUpdate(s);
        }
    }

    public void deleteMedici(List<Medici> Medicis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Medici s : Medicis) {
            currentSession.delete(currentSession.find(Medici.class, s.getId_medico()));
        }
    }

    public void deleteMediciById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.delete(currentSession.find(Medici.class, id));
    }
}
