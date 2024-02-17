package com.smartLibrary.smartLibrary.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(
        title = "Smart Library API", 
        description = "This is a Smart Library API", 
        summary = "This library-api will add, delete,create and update ", 
        termsOfService = "T&C", 
        contact = @Contact(
                name = "Smart Library", email = "princepravin@email.com"), 
        license = @License(name = "Apache 2.0"), 
        version = "1.0.0")
        )
public class OpenApiConfig {
    
}
