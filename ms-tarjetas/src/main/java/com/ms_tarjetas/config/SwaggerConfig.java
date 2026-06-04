package com.ms_tarjetas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class SwaggerConfig {
    @Bean
    public OpenAPI tarjetasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Tarjetas API")
                        .version("1.0.0")
                        .description("Documentación técnica del microservicio de autos"));
    }
}
