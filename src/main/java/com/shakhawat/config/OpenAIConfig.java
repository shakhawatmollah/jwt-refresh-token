package com.shakhawat.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

//@OpenAPIDefinition(
//		  info = @Info(
//				    title = "Client API",
//				    version = "1.01",
//				    description = "Project for Spring 6 Boot 3 - Spring Boot Refresh Token with JWT",
//				    contact = @Contact(
//				      name = "Shakhawat Mollah",
//				      email = "shakhawat.mollah@gmail.com"
//				    ),
//				    license = @License(
//				      url = "http://www.apache.org/licenses/LICENSE-2.0.html",
//				      name = "Apache 2.0"
//				    )
//				  ),
//				  security = {
//				    @SecurityRequirement(
//				      name = "bearerAuth"
//				    )
//				  },
//				  servers = {
//				    @Server(
//				      description = "Development Server",
//				      url = "http://localhost:8080"
//				    ),
//				    @Server(
//				      description = "Production Server",
//				      url = "http://localhost:9090"
//				    )
//				  }
//				)
//@SecurityScheme(
//      name = "bearerAuth",
//      description = "JWT auth description", 
//      scheme = "bearer",
//      type = SecuritySchemeType.HTTP,
//      bearerFormat = "JWT",
//      in = SecuritySchemeIn.HEADER
//    )
@Configuration
public class OpenAIConfig {

	@Value("${mollah.openapi.dev-url}")
	private String devUrl;

	@Value("${mollah.openapi.prod-url}")
	private String prodUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in Development environment");

		Server prodServer = new Server();
		prodServer.setUrl(prodUrl);
		prodServer.setDescription("Server URL in Production environment");

		Contact contact = new Contact();
		contact.setEmail("shakhawat.mollah@gmail.com");
		contact.setName("Shakhawat Mollah");
		contact.setUrl("https://www.bezkoder.com");

		License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

		Info info = new Info().title("Tutorial Management API").version("1.0").contact(contact)
				.description("This API exposes endpoints to manage tutorials.")
				.termsOfService("https://www.bezkoder.com/terms").license(mitLicense);
		
		SecurityScheme srcScheme = new SecurityScheme();
		srcScheme.setName("bearerAuth");
		srcScheme.setDescription("JWT auth description");
		srcScheme.setScheme("bearer");
		srcScheme.setBearerFormat("JWT");
		srcScheme.in(SecurityScheme.In.HEADER);
		srcScheme.type(SecurityScheme.Type.HTTP);

		SecurityRequirement sr = new SecurityRequirement();
		sr.addList("bearerAuth");
		
		return new OpenAPI().info(info).servers(List.of(devServer, prodServer)).components(new Components().addSecuritySchemes("bearerAuth",srcScheme)).addSecurityItem(sr);
	}

}
