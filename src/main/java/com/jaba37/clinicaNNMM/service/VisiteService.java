package com.jaba37.clinicaNNMM.service;

import com.jaba37.clinicaNNMM.dao.VisiteDao;
import com.jaba37.clinicaNNMM.model.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisiteService {

    @Autowired
    private VisiteDao VisiteDao;

    public List<Visite> getVisite() {
        return VisiteDao.getVisite();
    }

    public Visite getVisiteById(Integer id) {
        return VisiteDao.getVisiteById(id);
    }

    public void saveOrUpdateVisite(List<Visite> visites) {
        VisiteDao.saveOrUpdateVisite(visites);
    }

    public void deleteVisite(List<Visite> visites) {
        VisiteDao.deleteVisite(visites);
    }

    public void deleteVisiteById(Integer id) {
        VisiteDao.deleteVisiteById(id);
    }
}
