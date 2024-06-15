package com.example.ecommercepi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "KarlMarket", version = "0.0.1", description = "Mercado Socialista KARLMARKET! - Projeto Integrador do SENAI FATESG, turma de Engenharia de Software - 5º período.",
		contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Karl Market", email = "julioykawahata@gmail.com")))

@SpringBootApplication
public class ECommercePiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommercePiApplication.class, args);
	}

}