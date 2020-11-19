package com.griso.hexagonal.common.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiPublicProduct() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Product")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.griso.hexagonal.product.adapter.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .pathMapping("/")
                .securitySchemes(Lists.newArrayList(apiKey()))
                .apiInfo(metaDataProduct());
    }

    @Bean
    public Docket apiTest() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Test API")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.griso.hexagonal.common.adapter.rest.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(true)
                .pathMapping("/")
                .securitySchemes(null)
                .apiInfo(metaDataProduct());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT Bearer", "Authorization", "header");
    }

    private ApiInfo metaDataProduct() {
        Contact contact = new Contact("Albert Griso Mendez", "https://github.com/agrisom", "albert.griso.mendez@gmail.com");

        return new ApiInfo(
                "Spring RESTFull - Product public Services",
                "Services used by users to view Products data",
                "0.0.1-SNAPSHOT",
                null,
                contact,
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
