package com.jaba37.clinicaNNMM.service;

import com.jaba37.clinicaNNMM.dao.PazientiDao;
import com.jaba37.clinicaNNMM.model.Pazienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Service
@Transactional
public class PazientiService {

    @Autowired
    private PazientiDao PazientiDao;


    public List<Pazienti> getPazienti() {
        return PazientiDao.getPazienti();
    }

    public Pazienti getPazientiById(Integer id) {
        return PazientiDao.getPazientiById(id);
    }
    public List<Pazienti> getPazientiByEmail1(String email) {
        return PazientiDao.getPazientiByEmail1(email);
    }
    /*
    public Pazienti register(Pazienti pazienti){
        return PazientiDao.register(pazienti);
    }

    public Pazienti login(Pazienti pazienti){
        return PazientiDao.login(pazienti);
    }
*/
    public Pazienti getPazientiByEmail(String email){
        try {
            return PazientiDao.getPazientiByEmail(email);
        }catch (NoResultException e){
            return null;
        }
    }

    public boolean saveOrUpdatePazienti(Pazienti Pazientis) {
        if(this.getPazientiByEmail(Pazientis.getEmail())!=null && Pazientis.getId_paziente() == null) {
            return false;
        }
        PazientiDao.saveOrUpdatePazienti(Pazientis);
        return true;
    }

    public void deletePazienti(List<Pazienti> Pazientis) {
        PazientiDao.deletePazienti(Pazientis);
    }

    public void deletePazientiById(Integer id) {
        PazientiDao.deletePazientiById(id);
    }
}
