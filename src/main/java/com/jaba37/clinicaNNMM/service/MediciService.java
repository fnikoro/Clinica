package com.jaba37.clinicaNNMM.service;

import com.jaba37.clinicaNNMM.dao.MediciDao;
import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.model.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MediciService {

    @Autowired
    private MediciDao MediciDao;

    public List<Medici> getMedici() {
        return MediciDao.getMedici();
    }

    
    public List<Medici> getMediciDisponibili() {
        return MediciDao.getMediciDisponibili();
    }

    
    public List<Medici> getMediciByIdReparto (Integer id) {
        return MediciDao.getMediciByIdReparto(id);
    }

    
    public List<String> getListaOrariDisponibiliByMedicoId(Integer id) {
        return MediciDao.getListaOrariDisponibiliByMedicoId(id);
    }

    public Medici getMediciById(Integer id) {
        return MediciDao.getMediciById(id);
    }

    public void saveOrUpdateMedici(List<Medici> Medicis) {
        MediciDao.saveOrUpdateMedici(Medicis);
    }

    public void deleteMedici(List<Medici> Medicis) {
        MediciDao.deleteMedici(Medicis);
    }

    public void deleteMediciById(Integer id) {
        MediciDao.deleteMediciById(id);
    }

}
