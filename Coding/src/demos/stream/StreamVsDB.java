package demos.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StreamVsDB {
    List<Employee> employees;
    
    private void query() {
        Predicate<Employee> predicate;
        // Without manager
        System.out.println("\nEmployees without boss:\t");
        predicate = e -> e.getManager_id() == -1;
        // or
        predicate = new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getManager_id() == -1;
            }
        };
        employees.stream()
                .filter(predicate)
                //or use lamda directly:
                //.filter(e->e.getManager_id()==-1)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Count by department
        System.out.println("\nEmployee count by department:\t");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment(), Collectors.counting())));
        // Total salary by department
        System.out.println("\nTotal salary by department:\t");
        ToIntFunction<Employee> toIntFunction = new ToIntFunction<Employee>() {
            @Override
            public int applyAsInt(Employee e) {
                return e.getSalary();
            }
        };
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment(),
                        Collectors
                                //.summingInt(e->e.getSalary())
                                // or
                                .summingInt(toIntFunction)
                )));
        System.out.println("\nPerson with highest salary by department:\t");
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment(),
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                        //or
                        //Collectors.maxBy((e1,e2)->e1.getSalary()-e2.getSalary())
                )));
        System.out.println("\nHighest salary by department:\t");
        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment(),
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ));
        map.forEach((key, value)->System.out.print(key + ": " + value.get().getSalary() + ", "));
        // or
        BiConsumer<String, Optional<Employee>> biConsumer = new BiConsumer<String, Optional<Employee>>() {
            @Override
            public void accept(String key, Optional<Employee> value) {
                System.out.print(key + ": " + value.get().getSalary() + ", ");
            }
        };
        map.forEach(biConsumer);

        // Sort by salary
        System.out.println("\nSorted by salary");
        System.out.println(employees.stream().sorted().collect(Collectors.toList()));   //Exception if Employee doesn't implement Comparable: can't cast Employee to Comparable
        // Sort by salary within departments
        Map<String, List<Employee>> map1;
        System.out.println("\nSorted by salary within departments with sort method");
        map1 = employees.stream().sorted()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.toList()));
        System.out.println(map1);

        Map<String, Set<Employee>> map2;
        System.out.println("\nsalary within departments with Set");
        map2 = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.toSet()));
        System.out.println(map2);
        System.out.println("\nSorted by salary within departments with TreeSet");
        map2 = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), Collectors.toCollection(TreeSet<Employee>::new)));
        System.out.println(map2);
        System.out.println("\nSorted by salary within departments with map factory and TreeSet");
        map2 = employees.stream()
                .collect(Collectors.groupingBy(employee -> employee.getDepartment(), TreeMap::new, Collectors.toCollection(TreeSet<Employee>::new)));
        System.out.println(map2);
    }

    public static void main(String[] args) {
        StreamVsDB streamVsDB = new StreamVsDB();
        streamVsDB.init();
        streamVsDB.query();
    }

    private void init() {
        employees = new ArrayList<>();
        Employee employee;
        
        employee = new Employee(101, "Peter");
        employee.setTtile("CEO");
        employee.setDepartment("Management");
        employee.setLocation("New York");
        employee.setManager_id(-1);
        employee.setSalary(1_000_000);
        employees.add(employee);

        employee = new Employee(102, "Emma");
        employee.setTtile("HR President");
        employee.setDepartment("Management");
        employee.setLocation("New York");
        employee.setManager_id(101);
        employee.setSalary(300_000);
        employees.add(employee);
        
        employee = new Employee(103, "Jonathan");
        employee.setTtile("CTO");
        employee.setDepartment("Management");
        employee.setLocation("Jersey City");
        employee.setManager_id(101);
        employee.setSalary(500_000);
        employees.add(employee);

        employee = new Employee(104, "Clarie");
        employee.setTtile("Accounting President");
        employee.setDepartment("Management");
        employee.setLocation("New York");
        employee.setManager_id(101);
        employee.setSalary(200_000);
        employees.add(employee);

        employee = new Employee(201, "Judy");
        employee.setTtile("Specialist");
        employee.setDepartment("HR");
        employee.setLocation("Tempa");
        employee.setManager_id(102);
        employee.setSalary(100_000);
        employees.add(employee);

        employee = new Employee(201, "Brian");
        employee.setTtile("Director");
        employee.setDepartment("IT");
        employee.setLocation("Jersey City");
        employee.setManager_id(103);
        employee.setSalary(260_000);
        employees.add(employee);

        employee = new Employee(202, "Brian");
        employee.setTtile("Director");
        employee.setDepartment("Accounting");
        employee.setLocation("Jersey City");
        employee.setManager_id(104);
        employee.setSalary(160_000);
        employees.add(employee);

        employee = new Employee(301, "Jack");
        employee.setTtile("Senior Developer");
        employee.setDepartment("IT");
        employee.setLocation("Tempa");
        employee.setManager_id(201);
        employee.setSalary(180_000);
        employees.add(employee);

        employee = new Employee(302, "David");
        employee.setTtile("Accountant");
        employee.setDepartment("Accounting");
        employee.setLocation("New York");
        employee.setManager_id(202);
        employee.setSalary(120_000);
        employees.add(employee);

    }
}

class Employee implements Comparable<Employee>{
    private int id, manager_id, salary;
    private String name, title, department, location;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(((Employee) o).getId(), getId());
    }

    public String toString() {
        return "Id:" + id
                + ", name:" + name
                + ", title:" + title
                + ", salary:" + salary;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTttle() {
        return title;
    }

    public String getDepartment() {
        return department;
    }

    public String getLocation() {
        return location;
    }

    public int getManager_id() {
        return manager_id;
    }

    public int getSalary() {
        return salary;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTtile(String title) {
        this.title = title;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

}