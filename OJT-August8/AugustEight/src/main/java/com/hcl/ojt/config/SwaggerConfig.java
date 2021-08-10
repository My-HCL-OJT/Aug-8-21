package com.hcl.ojt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	private ApiInfo apiInfo() {
		return new ApiInfo("AUG 8 Project", "Aug 8 project", "0.0.1-SNAPSHOT", null, new Contact("Sahil Yadav", null, "sahil.yadav@hcl.com"), null, null, Collections.emptySet());
	}
	
	@Bean
	public Docket jsonApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.hcl.phase1.project")).build();
	}

}
