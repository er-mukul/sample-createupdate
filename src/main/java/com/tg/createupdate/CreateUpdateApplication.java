package com.tg.createupdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.tg.createupdate.*")
public class CreateUpdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreateUpdateApplication.class, args);
	}

}
