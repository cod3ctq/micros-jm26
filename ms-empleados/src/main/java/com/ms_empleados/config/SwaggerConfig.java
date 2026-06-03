package com.ms_empleados.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Esta Clase la creamos para poder generar la documentación técnica de Spring
@Configuration // Para indicar que esta Clase tiene configuraciones de Spring
public class SwaggerConfig {
    @Bean // Indica que es un Objeto administrado por Spring, ejecuta el metodo y crea este Objeto en automático
    public OpenAPI empleadosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Empleados API")
                        .version("1.0.0")
                        .description("Documentación técnica del microservicio de empleados"));
    }
}