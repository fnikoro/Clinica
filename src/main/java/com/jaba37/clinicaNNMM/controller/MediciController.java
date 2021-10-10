package com.jaba37.clinicaNNMM.controller;

import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.service.MediciService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class MediciController {

    @Autowired
    private MediciService mediciService;

    @GetMapping("/get-medici")
    public List<Medici> getMedici() {
        return mediciService.getMedici();
    }

    //ADDED
    @GetMapping("/get-medici-disponibili")
    public List<Medici> getMediciDisponibili() {
        return mediciService.getMediciDisponibili();
    }

    @GetMapping("/get-medici/{id}")
    public Medici getMediciById(@PathVariable("id") Integer id) {
        return mediciService.getMediciById(id);
    }

    @PostMapping("/save-medici")
    public void saveMedici(@RequestBody @NotNull List<Medici> medicis) {
        mediciService.saveOrUpdateMedici(medicis);
    }

    @DeleteMapping("/cancella-medici")
    public void deleteMedici(@RequestBody @NotNull List<Medici> medicis) {
        mediciService.deleteMedici(medicis);
    }

    @DeleteMapping("/cancella-medici/{id}")
    public void deleteMediciById(@PathVariable("id") Integer id) {
        mediciService.deleteMediciById(id);
    }
}
