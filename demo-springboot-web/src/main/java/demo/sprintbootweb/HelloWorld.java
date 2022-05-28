package demo.sprintbootweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/hello")
	public String sayHello(@RequestParam String name) {
		String msg = "{ Hello: "+name+" }";
		log.info(name);
		return msg;	
	}
}
