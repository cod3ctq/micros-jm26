package com.ms_empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Anotación "madre" de Spring Boot, indica que esta Clase es la principal desde donde arrancará toda la aplicación, enciende el Spring Boot
public class MsEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmpleadosApplication.class, args);
	}

}