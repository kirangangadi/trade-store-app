package com.db.tradestore.foundation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String PACKAGE = "com.db.tradestore";

	/**
	 * enabling swagger
	 */
	@Bean
	public Docket tradeApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(PACKAGE))
				.build().securitySchemes(basicScheme());
	}

	/**
	 * adding basic Auth scheme to Swagger
	 *
	 * @return scheme list
	 */
	private List<SecurityScheme> basicScheme() {
		List<SecurityScheme> schemeList = new ArrayList<>();
		schemeList.add(new BasicAuth("basicAuth"));
		return schemeList;
	}
}
