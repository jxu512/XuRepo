package demo.sprintbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

// Extends needed if to be deployed in standalone tomcat
@SpringBootApplication
@ComponentScan({" demo.sprintbootweb"," demo.ws"})
public class HelloApplication extends SpringBootServletInitializer {
	
    public static void main(String[] args) {

        SpringApplication.run(HelloApplication.class, args);
		
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HelloApplication.class);
    }

}