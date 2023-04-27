package com.knoldus.projectservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;


//http://localhost:8080/swagger-ui/index.html --> url
@Configuration
@OpenAPIDefinition(info =
@Info(
title = "Resilience swagger",
        version = "2.1.0",
        termsOfService = "Resilience Methods",
        license = @License(url = "https://www.google.com/search?channel=fs&client=ubuntu&q=knoldus+inc",  name = "KnoldusInc"),
        contact = @Contact(name = "Riya Sharma", email = "Riya.sharma@knoldus.com")
))
public class SwaggerConfig {

}
