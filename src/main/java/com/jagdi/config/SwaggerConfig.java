package com.jagdi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.Map;
import java.util.TreeMap;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	private static final String SCHEME_NAME = "basicAuth";
	private static final String SCHEME = "basic";

	@Bean
	public OpenAPI customOpenAPI() {
		var openApi = new OpenAPI().info(getInfo());

		addSecurity(openApi);

		return openApi;
	}

	private Info getInfo() {
		return new Info().license(getLicense());
	}

	private License getLicense() {
		return new License().name("Unlicense").url("https://unlicense.org/");
	}

	private void addSecurity(OpenAPI openApi) {
		var components = createComponents();
		var securityItem = new SecurityRequirement().addList(SCHEME_NAME);

		openApi.components(components).addSecurityItem(securityItem);
	}

	private Components createComponents() {
		var components = new Components();
		components.addSecuritySchemes(SCHEME_NAME, createSecurityScheme());

		return components;
	}

	private SecurityScheme createSecurityScheme() {
		return new SecurityScheme().name(SCHEME_NAME).type(SecurityScheme.Type.HTTP).scheme(SCHEME);
	}
	
//	@Bean
//	public OpenApiCustomiser sortSchemasAlphabetically() {
//	    return openApi -> {
//	        Map<String, Schema> schemas = openApi.getComponents().getSchemas();
//	        openApi.getComponents().setSchemas(new TreeMap<>(schemas));
//	    };
//	}
}