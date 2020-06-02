package com.plans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PlansMicroServices1Application {

	public static void main(String[] args) {
		SpringApplication.run(PlansMicroServices1Application.class, args);
	}

	
	@Bean
	public Docket docket() {
		ApiInfo info=new ApiInfoBuilder()
				.title("Plans MicroService Rest Documentation")
				.description("REST api for Getting plans")
				.contact(new Contact("rakesh", null, "rakeshsunakari95@gmail.com"))
				.license("sathyatech").licenseUrl("http:www.sathyatech.com")
				.build();
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.plans.restcontroller"))
				.paths(PathSelectors.any())
				.build().apiInfo(info);
	}
}
