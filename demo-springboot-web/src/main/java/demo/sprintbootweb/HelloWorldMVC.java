package demo.sprintbootweb;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldMVC {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/hello1")
	public String sayHello1(@RequestParam String name, Model model) {
		String msg = "{ Hello: "+name+" (mvc with Thymeleaf) }";
		log.info(msg);
		model.addAttribute("name", name);
		return "helloTemplate";	
	}

	@GetMapping("/hello2")
	@ResponseBody
	public String sayHello2(@RequestParam String name) {
		String msg = "<html><body>{ Hello: "+name+" (mvc with direct html / @ResponseBody) }</body></html>";
		log.info(msg);
		return msg;	
	}
	@GetMapping("/hello3")
	@ResponseBody
	public ResponseEntity<String> sayHello3(@RequestParam String name) {
		String msg = "{ Hello: "+name+" (mvc with ResponseEntity) }";
		log.info(msg);
		return new ResponseEntity<>(msg,HttpStatus.OK);	
	}
	@GetMapping("/hello4")
	public void sayHello4(@RequestParam String name, HttpServletRequest request, HttpServletResponse response) {
		String msg = "{ Hello: "+name+" (mvc with HttpServletResponse) }";
		Enumeration names = request.getHeaderNames();
		while(names.hasMoreElements()) {
			String header = (String) names.nextElement();
			log.info("header:"+request.getHeader(header));
		}
		log.info(msg);
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

}
