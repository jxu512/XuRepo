package demo.sprintboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorld {
	@Value("${name}")
	private String name;
	public void sayHello() {
		System.out.println("Hello "+name+"!");	}
}
