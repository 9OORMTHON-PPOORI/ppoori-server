package dev.goormthon.ppoori;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition(servers = {
		@Server(url = "/", description = "Default Server URL")
})
@SpringBootApplication
@EnableJpaAuditing
public class PpooriApplication {

	public static void main(String[] args) {
		SpringApplication.run(PpooriApplication.class, args);
	}

}
