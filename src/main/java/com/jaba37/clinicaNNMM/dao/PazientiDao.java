package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Pazienti;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PazientiDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Pazienti> getPazienti() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Pazienti", Pazienti.class).getResultList();
    }

    public Pazienti getPazientiById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Pazienti.class, id);
    }
    public List<Pazienti> getPazientiByEmail1(String email) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Pazienti where email = Pazienti.email", Pazienti.class).getResultList();

    }

    public Pazienti getPazientiByEmail(String email) throws NoResultException {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Pazienti> query = currentSession.createQuery("FROM Pazienti WHERE email = :email", Pazienti.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    public void saveOrUpdatePazienti(Pazienti pazientis) {
        Session currentSession = entityManager.unwrap(Session.class);
            currentSession.saveOrUpdate(pazientis);
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
