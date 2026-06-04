package com.ns_cuenta.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {

    @Bean
    public OpenAPI autosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Autos API")
                        .version("1.0.0")
                        .description("Documentación técnica del microservicio de tipo_cuenta"));
    }



}
