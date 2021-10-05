package com.jaba37.clinicaNNMM.controller;

import com.jaba37.clinicaNNMM.model.Pazienti;
import com.jaba37.clinicaNNMM.service.PazientiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class PazientiController {

    @Autowired
    private PazientiService pazientiService;

    @GetMapping("/get-pazienti")
    public List<Pazienti> getPazienti() {
        return pazientiService.getPazienti();
    }

    @GetMapping("/get-pazienti/{id}")
    public Pazienti getPazientiById(@PathVariable("id") Integer id) {
        return pazientiService.getPazientiById(id);
    }

    @PostMapping("/save-pazienti")
    public void savePazienti(@RequestBody @NotNull List<Pazienti> pazientis) {
        pazientiService.saveOrUpdatePazienti(pazientis);
    }

    @DeleteMapping("/cancella-pazienti")
    public void deletePazienti(@RequestBody @NotNull List<Pazienti> pazientis) {
        pazientiService.deletePazienti(pazientis);
    }

    @DeleteMapping("/cancella-pazienti/{id}")
    public void deletePazientiById(@PathVariable("id") Integer id) {
        pazientiService.deletePazientiById(id);
    }
}
