package dev.goormthon.ppoori;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PpooriApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpooriApplication.class, args);
	}

}
