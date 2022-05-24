package demo.sprintboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	private HelloWorld hello;
    public static void main(String[] args) {

        SpringApplication.run(SpringBootConsoleApplication.class, args);
		
    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {
	
        hello.sayHello();
		
    }
}