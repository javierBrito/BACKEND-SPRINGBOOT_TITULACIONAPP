package ec.gob.educacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration 
@Profile("dev")
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ec.gob.educacion.controlador.titulacion"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API-REST - TITULACION 1.0",
				"Descripción Api-Rest Titulacion 1.0",
				"1.0",
				"https://www.gobiernoelectronico.gob.ec/politica-datos-personales/",
				new Contact("Ministerio de Educación", "https://educacion.gob.ec", "soportetic@educacion.gob.ec"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
	
	

}
