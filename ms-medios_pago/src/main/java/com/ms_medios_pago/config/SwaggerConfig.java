package com.ms_medios_pago.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI medips_pagoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Medios Pago API")
                        .version("1.0.0")
                        .description("Documentación técnica del microservicio de medios pago"));
    }

}
