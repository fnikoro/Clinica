package com.jaba37.clinicaNNMM.controller;

import com.jaba37.clinicaNNMM.model.Reparti;
import com.jaba37.clinicaNNMM.service.RepartiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class RepartiController {

    @Autowired
    private RepartiService repartiService;

    @GetMapping("/get-reparti")
    public List<Reparti> getReparti() {
        return repartiService.getReparti();
    }

    @GetMapping("/get-reparti/{id}")
    public Reparti getRepartiById(@PathVariable("id") Integer id) {
        return repartiService.getRepartiById(id);
    }

    @PostMapping("/save-reparti")
    public void saveReparti(@RequestBody @NotNull List<Reparti> repartis) {
        repartiService.saveOrUpdateReparti(repartis);
    }

    @DeleteMapping("/cancella-reparti")
    public void deleteReparti(@RequestBody @NotNull List<Reparti> repartis) {
        repartiService.deleteReparti(repartis);
    }

    @DeleteMapping("/cancella-reparti/{id}")
    public void deleteRepartiById(@PathVariable("id") Integer id) {
        repartiService.deleteRepartiById(id);
    }
}
