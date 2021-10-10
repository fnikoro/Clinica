package com.jaba37.clinicaNNMM.dao;

import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.model.Visite;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static com.jaba37.clinicaNNMM.model.Medici.NUMERO_BLOCCHI_ORARI;
import static com.jaba37.clinicaNNMM.model.Medici.NUMERO_GIORNI;

@Repository
public class MediciDao {

    @Autowired
    private EntityManager entityManager;

    public List<Medici> getMedici() {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.createQuery("FROM Medici", Medici.class).getResultList();
    }

    //ADDED
    public List<Medici> getMediciDisponibili() {
        List<Medici> listaMedici = getMedici();
        List<Medici> listaMediciDisponibili = new ArrayList<>();
        int controlloInclusione;

        initializeDisponibilita(listaMedici);

        updateDisponibilitaMedici(listaMedici);

        for (int i = 0; i < listaMedici.size(); i++) {
            controlloInclusione = 0;

            for (int k = 0; k < NUMERO_GIORNI; k++) {
                if (controlloInclusione == 1) {
                    break;
                }

                for (int j = 0; j < NUMERO_BLOCCHI_ORARI; j++) {

                    //NON SEMPLIFICARE, romperebbe la logica in quanto "Not" darebbe il risultato opposto al risultato effettivo
                    if (listaMedici.get(i).getDisponibilitaAtIndexInDayJ(k, j) == true) {
                        controlloInclusione++;
                        listaMediciDisponibili.add(listaMedici.get(i));
                        break;
                    }
                }
            }
        }
        return listaMediciDisponibili;
    }

    public Medici getMediciById(Integer id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.find(Medici.class, id);
    }

    //ADDED
    private void createMediciDisponibilita(Medici medico) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medico.getDateFormatter());
        LocalDate today = LocalDate.now();
        LocalDate startOfBooking = today.plusDays(7);
        LocalDate endOfBooking = today.plusDays(37);
//        LocalDate endOfBooking = LocalDate.of(2021, Month.NOVEMBER, 30);
        int daysBetween = (int) ChronoUnit.DAYS.between(startOfBooking, endOfBooking);

        LocalDateTime dataOra = startOfBooking.atTime(8, 0);
        String formatDateTime = "";

        for (int i = 0; i <= daysBetween; i++) {
            for (int k = 0; k < NUMERO_BLOCCHI_ORARI; k++) {

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
    private void initializeDisponibilita(List<Medici> medicis) {
        for (int i = 0; i < medicis.size(); i++) {
            createMediciDisponibilita(medicis.get(i));
            for (int k = 0; k < NUMERO_GIORNI; k++) {
                for (int j = 0; j < NUMERO_BLOCCHI_ORARI; j++) {
                    medicis.get(i).setDisponibilitaAtIndexInDayJ(k, j, true);
                }
            }
        }
    }

    //ADDED
    private void updateDisponibilitaMedici(List<Medici> medicis) {
        String dataPrenotazione_Visita = "";
        int indiceListaOrario;
        int controlloInvocazioneBreak;

        Session currentSession = entityManager.unwrap(Session.class);
        Query<Visite> getVisite = currentSession.createQuery("FROM Visite", Visite.class);
        List<Visite> listaVisite = getVisite.getResultList();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medicis.get(1).getDateFormatter());

        for (int i = 0; i < medicis.size(); i++) {

            for (int k = 0; k < listaVisite.size(); k++) {
              dataPrenotazione_Visita = listaVisite.get(k).getData_prenotazione().format(formatter);
                controlloInvocazioneBreak = 0;
                indiceListaOrario = 0;
                if ((medicis.get(i).getId_medico().equals(listaVisite.get(k).getMedici().getId_medico()))) {

                    for (int j = 0; j < NUMERO_GIORNI; j++) {

                        if(controlloInvocazioneBreak != 0) {
                            break;
                        }

                        for (int q = 0; q < NUMERO_BLOCCHI_ORARI; q++) {

                            if (medicis.get(i).getListaOrariAtIndex(indiceListaOrario).equals(dataPrenotazione_Visita)) {
                                medicis.get(i).setDisponibilitaAtIndexInDayJ(j, q, false);
                            } else {
                                medicis.get(i).setDisponibilitaAtIndexInDayJ(j, q, true); //unsure
                            }
                            indiceListaOrario++;
                            if(indiceListaOrario == medicis.get(i).getListaOrari().size()){
                                controlloInvocazioneBreak++;
                                break;
                            }
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