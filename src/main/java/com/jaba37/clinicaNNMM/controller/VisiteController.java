package com.jaba37.clinicaNNMM.controller;


import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.model.Pazienti;
import com.jaba37.clinicaNNMM.model.Visite;
import com.jaba37.clinicaNNMM.service.MediciService;
import com.jaba37.clinicaNNMM.service.PazientiService;
import com.jaba37.clinicaNNMM.service.VisiteService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class VisiteController {

    @Autowired
    private VisiteService visiteService;

    @Autowired
    private MediciService mediciService;

    @Autowired
    private PazientiService pazientiService;

    @GetMapping("/get-visite")
    public List<Visite> getVisite() {
        return visiteService.getVisite();
    }

    @GetMapping("/get-visite/{id}")
    public Visite getVisiteById(@PathVariable("id") Integer id) {
        return visiteService.getVisiteById(id);
    }

    @GetMapping("/get-visite-by-user/{id}")
    public List<Visite> getVisiteByUserId(@PathVariable("id") Integer id) {
        return visiteService.getVisiteByUserId(id);
    }

//    @PostMapping("/save-visite")
//    public void saveVisite(@RequestBody @NotNull List<Visite> visitis) {
//        visiteService.saveOrUpdateVisite(visitis);
//    }

    @PostMapping(value={"/save-visite", "/save-visite/{id_medico}/{id_paziente}"})
    public void saveVisite(@RequestBody @NotNull Visite visita, @PathVariable("id_medico") Integer id_medico, @PathVariable("id_paziente") Integer id_paziente) {
        if(id_medico != null && id_paziente != null ) {
            Medici medico = mediciService.getMediciById(id_medico);
            visita.setMedici(medico);
            Pazienti paziente = pazientiService.getPazientiById(id_paziente);
            visita.setPazienti(paziente);
        }
        visiteService.saveOrUpdateVisite(visita);
    }

    @DeleteMapping("/cancella-visite")
    public void deleteVisite(@RequestBody @NotNull List<Visite> visitis) {
        visiteService.deleteVisite(visitis);
    }

    @DeleteMapping("/cancella-visite/{id}")
    public void deleteVisiteById(@PathVariable("id") Integer id) {
        visiteService.deleteVisiteById(id);
    }
}
