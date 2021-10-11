package com.jaba37.clinicaNNMM.controller;

import com.jaba37.clinicaNNMM.model.Pazienti;
import com.jaba37.clinicaNNMM.service.PazientiService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class PazientiController {

    @Autowired
    private PazientiService pazientiService;

    @GetMapping("/get-pazienti")
    public List<Pazienti> getPazienti() {
        return pazientiService.getPazienti();
    }

    @GetMapping("/get-pazienti/{email}")
    public Pazienti getPazientiByEmail(@PathVariable("email") String email) {
        return pazientiService.getPazientiByEmail(email);
    }

    @GetMapping("/get-pazienti1/{email}")
    public List<Pazienti> getPazientiByEmail1(@PathVariable("email") String email) {
        return pazientiService.getPazientiByEmail1(email);
    }

/*
    @GetMapping("/register/{email}")
    public Pazienti register(@PathVariable("email") Pazienti email){
        return pazientiService.register(email);
    }

    @GetMapping("/login/{email}")
    public Pazienti login(@PathVariable("email") Pazienti email){
        return pazientiService.login(email);
    }

*/

    @PostMapping("/save-pazienti")
    public void savePazienti(@RequestBody @NotNull Pazienti pazientis) {
        if( !pazientiService.saveOrUpdatePazienti(pazientis)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
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
