package net.multineural.kademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KademoPublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(KademoPublisherApplication.class, args);
	}

}
