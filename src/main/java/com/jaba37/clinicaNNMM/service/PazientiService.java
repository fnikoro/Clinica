package com.jaba37.clinicaNNMM.service;

import com.jaba37.clinicaNNMM.dao.PazientiDao;
import com.jaba37.clinicaNNMM.model.Pazienti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void saveOrUpdatePazienti(List<Pazienti> Pazientis) {
        PazientiDao.saveOrUpdatePazienti(Pazientis);
    }

    public void deletePazienti(List<Pazienti> Pazientis) {
        PazientiDao.deletePazienti(Pazientis);
    }

    public void deletePazientiById(Integer id) {
        PazientiDao.deletePazientiById(id);
    }
}
