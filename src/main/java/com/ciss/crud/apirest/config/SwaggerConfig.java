package com.ciss.crud.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ciss.crud.apirest"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
                //Dados que ficarão disponível no swagger.
    private ApiInfo metaInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "API CRUD",
                "API REST cadastro de funcionários.",
                "1.0",
                "Terms of service",
                new Contact("Alex Domingues da Silva", "https://www.linkedin.com/in/alex-silva-763058a3/",
                        "Alex.ddsilva@gmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }
}
