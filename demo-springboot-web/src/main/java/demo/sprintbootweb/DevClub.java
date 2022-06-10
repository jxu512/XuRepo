package demo.sprintbootweb;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/club")
public class DevClub {
	
	private Map<String, Integer> club = null;
	
	public DevClub() {
		club = new ConcurrentHashMap<>();
		club.put("Jeff", 1);
	}

	@GetMapping("/get-all") 
	public Map<String, Integer> getAll() {
		return club;
	}
	@GetMapping("/get") 
	public String get(@RequestParam String name) {
		Integer obj = club.get(name);
		if(obj==null) {
			return name + " not in club, please register first.";
		}
		else return name+":"+obj.intValue();
	}
	@PostMapping("/register") 
	public String register(@RequestParam("name") String name) {
		Integer obj = club.get(name);
		if(obj!=null) {
			return name + " already registered.";
		}
		else {
			club.put(name, 1);
			return name+":"+club.get(name);
		}
	}
	// Put not supported by HTTP, test with curl or Ajax
	// curl -X PUT -dname=Jessica http://localhost:7777/club/register-put
	@PutMapping("/register-put") 
	public String register1(@RequestParam("name") String name) {
		Integer obj = club.get(name);
		if(obj!=null) {
			return name + " already registered.";
		}
		else {
			club.put(name, 1);
			return name+":"+club.get(name);
		}
	}
	@DeleteMapping("/delete") 
	public String delete(@RequestParam("name") String name) {
		Integer obj = club.get(name);
		if(obj==null) {
			return name + " not exist.";
		}
		else {
			club.remove(name);
			return name+" deleted";
		}
	}

}
