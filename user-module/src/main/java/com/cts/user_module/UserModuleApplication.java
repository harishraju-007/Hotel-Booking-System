package com.cts.user_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class UserModuleApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserModuleApplication.class, args);
	}
}
