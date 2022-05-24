package demo.sprintboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Component or @Service when no Configuration defined
public class HelloWorld {
	@Value("${name}")
	private String name;
	public void sayHello() {
		System.out.println("Hello "+name+"!");	}
}
