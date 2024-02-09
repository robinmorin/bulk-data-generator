package com.personal.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "${projectName}",
        version = "${projectVersion:0.0.1}",
        description = "${projectDescription}"
))
public class OpenApiConfig {

}