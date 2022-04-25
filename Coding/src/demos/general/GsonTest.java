package demos.general;

import com.google.gson.Gson;

public class GsonTest {	
	public static void main(String[] args) {
		
		Gson gson = new Gson();
		Employee e = new Employee(1,"Jeff","citi", "JC");
		System.out.println(gson.toJson(e));
		
		String json = "{\"id\":1,\"name\":\"Jeff\",\"company\":\"Barclays\",\"location\":\"NJ\"}";
		System.out.println(gson.fromJson(json, Employee.class));
		
	}
}

class Employee {
	String name;
	String company;
	String location;
	
	public int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(int id, String name, String company,String location) {
		this.id=id;
		this.name=name;
		this.company=company;
		this.location=location;
	}
	public String toString() {
		return "{"+id+","+name+","+company+","+location+"}";
	}
}