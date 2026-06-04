package com.banco.transacciones.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI transaccionesOpenApi() {
        return new OpenAPI().info(new Info()
                .title("transacciones-service")
                .version("1.0.0")
                .description("Microservicio responsable de retiros, depósitos, transferencias, pagos con tarjeta y reversos."));
    }
}
