package com.riwi.LibrosYa.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

// Configuracion de swagger
@Configuration
@OpenAPIDefinition(
    info = @Info(
        
        title = "Api para administrar una biblioteca",
        version = "1.0",
        description = "Documentación api para administrar una biblioteca"))
public class OpenApiConfig {
    
    // ruta swagger http://localhost:8080/api/v1/swagger-ui/index.html
}
