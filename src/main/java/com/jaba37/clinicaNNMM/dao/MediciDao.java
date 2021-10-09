package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.model.Visite;
import org.apache.tomcat.jni.Local;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
    public void createMediciDisponibilita(Medici medico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medico.getDateFormatter());
        LocalDate today = LocalDate.now();
        LocalDate startOfBooking = today.plusDays(7);
        LocalDate endOfBooking = LocalDate.of(2021, Month.NOVEMBER, 30);
        int daysBetween = (int) ChronoUnit.DAYS.between(startOfBooking, endOfBooking);

        LocalDateTime dataOra = startOfBooking.atTime(8, 0);
        String formatDateTime = "";

        for (int i = 0; i <= daysBetween; i++) {
            for (int k = 0; k < medico.getNumeroBlocchiOrari(); k++) {

                if (dataOra.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    dataOra = dataOra.plusDays(1);
                    dataOra = dataOra.withHour(8);
                    dataOra = dataOra.withMinute(0);
                    break;
                }

                if ((dataOra.getHour() == 13) && (dataOra.getMinute() == 0)) {
                    dataOra = dataOra.plusHours(1);
                }

                formatDateTime = dataOra.format(formatter);
                medico.add(formatDateTime);
                dataOra = dataOra.plusMinutes(30);

                if ((dataOra.getHour() == 18) && (dataOra.getMinute() == 0)) {
                    dataOra = dataOra.plusDays(1);
                    dataOra = dataOra.withHour(8);
                    dataOra = dataOra.withMinute(0);
                }
            }
        }
    }

    //ADDED
    public void initializeDisponibilita(Medici medico) {
        Arrays.fill(medico.getDisponibilita(), true);
    }

    //ADDED
    public void updateDisponibilitaMedici(List<Medici> medicis) {
        Instant conversione_firstStep;
        LocalDateTime conversione_secondStep;
        String dataPrenotazione_Visita = "";

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Visite> getVisite = currentSession.createQuery("FROM Visite", Visite.class);
        List<Visite> listaVisite = getVisite.getResultList();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medicis.get(1).getDateFormatter());

        for (int i = 0; i < medicis.size(); i++) {

            for (int k = 0; k < listaVisite.size(); k++) {
                conversione_firstStep = listaVisite.get(k).getData_prenotazione().toInstant();
                conversione_secondStep = LocalDateTime.from(conversione_firstStep);
                dataPrenotazione_Visita = conversione_secondStep.format(formatter);

                if ((medicis.get(i).getId_medico().equals(listaVisite.get(k).getMedici().getId_medico()))) {

                    for (int j = 0; j < medicis.get(i).getListaOrari().size(); j++) {

                        if (medicis.get(i).getListaOrari().get(j).equals(dataPrenotazione_Visita)) {
                            medicis.get(i).setDisponibilitaAtIndex(j, false);
                        } else {
                            medicis.get(i).setDisponibilitaAtIndex(j, true); //unsure
                        }
                    }
                }
            }
        }
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
