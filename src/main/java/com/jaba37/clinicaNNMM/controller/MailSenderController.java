package com.jaba37.clinicaNNMM.controller;

import com.jaba37.clinicaNNMM.util.MailSenderComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping
public class MailSenderController {

    @Autowired
    private MailSenderComponent mailSenderComponent;

    @PostMapping("/send-email/{dest}/{ogg}/{mess}")
    public void sendMmail(@PathVariable("dest") String dest, @PathVariable("ogg") String ogg, @PathVariable("mess") String mess) {
        mailSenderComponent.send(dest, ogg, mess);
    }
}
