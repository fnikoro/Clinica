package com.jaba37.clinicaNNMM;

import com.jaba37.clinicaNNMM.util.MailSenderComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ClinicaNnmmApplication {

	@Autowired
	private MailSenderComponent component;

	public static void main(String[] args) {
		SpringApplication.run(ClinicaNnmmApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() {
//
//		for (int i = 0; i < 1; i++) {
//			component.send("seba.sebastio5@gmail.com", "patata", "si");
//			System.out.println("Spammando... ");
//		}
//		System.out.println("Bro finito capolinea caput");

//	}
}