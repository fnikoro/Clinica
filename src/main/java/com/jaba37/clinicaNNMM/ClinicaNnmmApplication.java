package com.jaba37.clinicaNNMM;

//import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@SpringBootApplication
public class ClinicaNnmmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaNnmmApplication.class, args);
	}

//	@Bean
//	public Jackson2ObjectMapperBuilder jacksonBuilder() {
//		Jackson2ObjectMapperBuilder b = new Jackson2ObjectMapperBuilder();
//		b.propertyNamingStrategy(PropertyNamingStrategy.);
//		return b;
//	}

}
