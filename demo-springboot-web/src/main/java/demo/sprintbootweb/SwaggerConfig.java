package demo.sprintbootweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Default URI: /swagger-ui
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket demoApi() {
		
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(demoApiInfo())
                .select()                                  
                .apis(RequestHandlerSelectors.any())              
                .paths(PathSelectors.any())                          
                .build();                                           
	}
	
	private ApiInfo demoApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Spring boot web demo")
				.description("Spring boot web demo")
				.version("1.0")
				.build();
	}
}
