package demo1;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class GsonTestwithModules {
	public static void main(String[] args) {
		
		GsonBuilder builder = new GsonBuilder(); 
		// If no adapter provided, default reflection base adapter is used, which doesn't work in Java 9 and above
		//builder.registerTypeAdapter(Employee.class, new EmployeeAdapter()); // option 2: use customer adapter instead of reflection base
		Gson gson = builder.create(); 		
		Employee e = new Employee(1,"Jeff","citi", "JC");

		System.out.println(gson.toJson(e, Employee.class));
		
		String json = "{\"id\":1,\"name\":\"Jeff\",\"company\":\"Barclays\",\"location\":\"NJ\"}";
		System.out.println(gson.fromJson(json, Employee.class));
		
	}
}

class Employee {
	String name;
	String company;
	String location;
	int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee() {
		
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

/*
Since Java 9, Java has strong encapsulation with modules (indicated by module-info.java): Gson's reflection based type adapter won't be able to access 
class' internal implementation. Need to define customer adapter. 
If not using Java modules, all packages are put in unnamed module, refelction still works.  
*/
class EmployeeAdapter extends TypeAdapter<Employee> {
	
    public Employee read(JsonReader reader) throws IOException {

    	String field=null;
    	Employee emp = new Employee();
    	reader.beginObject();
    	while(reader.hasNext()) {
    		JsonToken token = reader.peek();
    		if(token.equals(JsonToken.NAME)) field=reader.nextName();
    		switch (field) {
    			case "id": emp.setId(reader.nextInt());break;
    			case "name": emp.setName(reader.nextString());break;
    			case "company": emp.setCompany(reader.nextString());break;
    			case "location": emp.setLocation(reader.nextString());break;
    		}
    	}
    	reader.endObject();
    	return emp;
    }
    public void write(JsonWriter writer, Employee emp) throws IOException {

    	writer.beginObject();
    	writer.name("id");
    	writer.value(emp.id);
    	writer.name("name");
    	writer.value(emp.name);
    	writer.name("company");
    	writer.value(emp.company);
    	writer.name("location");
    	writer.value(emp.location);
    	writer.endObject();
    }
 }