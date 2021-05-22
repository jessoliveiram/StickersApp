package br.com.stickers.StickersApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StickersAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StickersAppApplication.class, args);
	}

}
