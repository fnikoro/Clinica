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

    //ADDED
    public void updateDisponibilitaMedici(List<Medici> medicis) {
        Session currentSession = entityManager.unwrap(Session.class);

    }

    public void saveOrUpdateMedici(List<Medici> medicis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Medici s : medicis) {
            currentSession.saveOrUpdate(s);
        }
    }

    public void deleteMedici(List<Medici> medicis) {
        Session currentSession = entityManager.unwrap(Session.class);

        for (Medici s : medicis) {
            currentSession.delete(currentSession.find(Medici.class, s.getId_medico()));
        }
    }

    public void deleteMediciById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.delete(currentSession.find(Medici.class, id));
    }



}
