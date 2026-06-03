package com.ms_movimientos.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI movimientosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Movimientos API")
                        .version("1.0.0")
                        .description("Documentación técnica del microservicio de movimientos"));
    }
}
