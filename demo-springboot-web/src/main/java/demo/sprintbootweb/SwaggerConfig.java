package demo.sprintbootweb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.actuate.autoconfigure.endpoint.web.CorsEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.boot.actuate.autoconfigure.web.server.ManagementPortType;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver;
import org.springframework.boot.actuate.endpoint.web.EndpointMapping;
import org.springframework.boot.actuate.endpoint.web.EndpointMediaTypes;
import org.springframework.boot.actuate.endpoint.web.ExposableWebEndpoint;
import org.springframework.boot.actuate.endpoint.web.WebEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.annotation.ServletEndpointsSupplier;
import org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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
                .paths(PathSelectors.regex("/club/.*"))
                .build();                                           
	}
	
	private ApiInfo demoApiInfo() {
		
		return new ApiInfoBuilder()
				.title("Spring boot web demo")
				.description("Spring boot web demo")
				.version("1.0")
				.build();
	}

	// Below beans needed for swagger 2 to work with spring boot 2.6
	@Bean
	public WebMvcEndpointHandlerMapping webEndpointServletHandlerMapping(
			WebEndpointsSupplier webEndpointsSupplier, ServletEndpointsSupplier servletEndpointsSupplier, 
			ControllerEndpointsSupplier controllerEndpointsSupplier, EndpointMediaTypes endpointMediaTypes, 
			CorsEndpointProperties corsProperties, WebEndpointProperties webEndpointProperties, 
			Environment environment) {
	    List<ExposableEndpoint<?>> allEndpoints = new ArrayList<>();
	    Collection<ExposableWebEndpoint> webEndpoints = webEndpointsSupplier.getEndpoints();
	    allEndpoints.addAll(webEndpoints);
	    allEndpoints.addAll(servletEndpointsSupplier.getEndpoints());
	    allEndpoints.addAll(controllerEndpointsSupplier.getEndpoints());
	    String basePath = webEndpointProperties.getBasePath();
	    EndpointMapping endpointMapping = new EndpointMapping(basePath);
	    boolean shouldRegisterLinksMapping = this.shouldRegisterLinksMapping(webEndpointProperties, environment, basePath);
	    
	    return new WebMvcEndpointHandlerMapping(
	    		endpointMapping, webEndpoints, endpointMediaTypes, corsProperties.toCorsConfiguration(), 
	    		new EndpointLinksResolver(allEndpoints, basePath), shouldRegisterLinksMapping, null);
	    }


	private boolean shouldRegisterLinksMapping(WebEndpointProperties webEndpointProperties, Environment environment, String basePath) {
	        return webEndpointProperties.getDiscovery().isEnabled() && 
	        		((basePath!=null && basePath.length()>0) || ManagementPortType.get(environment).equals(ManagementPortType.DIFFERENT) );
	    }
}
