package com.jaba37.clinicaNNMM.controller;


import com.jaba37.clinicaNNMM.model.Medici;
import com.jaba37.clinicaNNMM.model.Pazienti;
import com.jaba37.clinicaNNMM.model.Reparti;
import com.jaba37.clinicaNNMM.model.Visite;
import com.jaba37.clinicaNNMM.service.MediciService;
import com.jaba37.clinicaNNMM.service.PazientiService;
import com.jaba37.clinicaNNMM.service.VisiteService;
import com.jaba37.clinicaNNMM.util.MailSenderComponent;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
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

    @Autowired
    private MailSenderComponent component;

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

            Reparti reparto = medico.getReparto();

            Pazienti paziente = pazientiService.getPazientiById(id_paziente);
            visita.setPazienti(paziente);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medico.getDateFormatter());
            String dataFormattata = visita.getData_prenotazione().format(formatter);


            visiteService.saveOrUpdateVisite(visita);
            String datiPrenotazione = "La prenotazione n. "+ visita.getId_visite() +", effettuata dal Sig.r "+ paziente.getCognome() + " " + paziente.getNome() + ", prenotata presso il Dott.r " + medico.getCognome() + " " + medico.getNome() +", del Reparto di " + reparto.getReparto() + ", in data " + dataFormattata + ", è stata appena cancellata. ";

            component.send(paziente.getEmail(),"Questa è una mail di prova",datiPrenotazione);
        }
       System.out.println("\n ....");
    }

    @DeleteMapping("/delete-visite")
    public void deleteVisite(@RequestBody @NotNull List<Visite> visitis) {
        visiteService.deleteVisite(visitis);
    }

    @CrossOrigin
    @DeleteMapping("/delete-visite/{id}")
    public void deleteVisiteById(@PathVariable("id") Integer id) {
        Visite visita = visiteService.getVisiteById(id);

        Medici medico = visita.getMedici();
        Pazienti paziente = visita.getPazienti();
        Reparti reparto = medico.getReparto();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(medico.getDateFormatter());
        String dataFormattata = visita.getData_prenotazione().format(formatter);

        String datiPrenotazione = "La prenotazione n. "+ visita.getId_visite() +", effettuata dal Sig.r "+ paziente.getCognome() + " " + paziente.getNome() + ", prenotata presso il Dott.r " + medico.getCognome() + " " + medico.getNome() +", del Reparto di " + reparto.getReparto() + ", in data " + dataFormattata + ", è stata appena cancellata. ";

        component.send(medico.getEmail(),"Una prenotazione nei tuoi confronti è stata cancellata ",datiPrenotazione);
        component.send(paziente.getEmail(),"Hai cancellato una prenotazione ",datiPrenotazione);

        visiteService.deleteVisiteById(id);
    }
}
