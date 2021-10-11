package com.jaba37.clinicaNNMM.controller;


import com.jaba37.clinicaNNMM.model.Visite;
import com.jaba37.clinicaNNMM.service.VisiteService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class VisiteController {

    @Autowired
    private VisiteService visiteService;

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

    @PostMapping("/save-visite")
    public void saveVisite(@RequestBody @NotNull List<Visite> visitis) {
        visiteService.saveOrUpdateVisite(visitis);
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
