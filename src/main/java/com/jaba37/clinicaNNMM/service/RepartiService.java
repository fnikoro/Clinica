package com.jaba37.clinicaNNMM.service;

import com.jaba37.clinicaNNMM.dao.RepartiDao;
import com.jaba37.clinicaNNMM.model.Reparti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RepartiService {

    @Autowired
    private RepartiDao RepartiDao;

    public List<Reparti> getReparti() {
        return RepartiDao.getReparti();
    }

    public Reparti getRepartiById(Integer id) {
        return RepartiDao.getRepartiById(id);
    }

    public void saveOrUpdateReparti(List<Reparti> repartis) {
        RepartiDao.saveOrUpdateReparti(repartis);
    }

    public void deleteReparti(List<Reparti> repartis) {
        RepartiDao.deleteReparti(repartis);
    }

    public void deleteRepartiById(Integer id) {
        RepartiDao.deleteRepartiById(id);
    }
}
