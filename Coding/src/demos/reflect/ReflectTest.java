package demos.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main (String[] args) throws IllegalAccessException, InvocationTargetException {

        System.out.println("Without security manager:");
        // reflection enables access to private fields and methods without security manager
        testReflect();

        // Use security manage to disable reflection
        System.setSecurityManager(new SecurityManager());
        System.out.println("With security manager:");
        testReflect();

    }
    private static void testReflect() throws IllegalAccessException, InvocationTargetException {
        Test test = new Test(1, "one");
        System.out.println("Public method: " + test.toString());
        //test.id = 5;  Can't access private id
        Field[] fields = test.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.format("Field %s = %s\n", field.getName(), field.get(test));
        }

        Method[] methods = test.getClass().getDeclaredMethods();
        methods[0].setAccessible(true);
        System.out.println(methods[0].invoke(test));


    }
}

// reflection works with all classes including final / immutable
final class Test {
    private int id;
    private String name;

    public Test (int id, String name) {
        this.id = id;
        this.name = name;
    }

    private String print() {
        return id + ": " +name;
    }

    public String toString() {
        return print();
    }
}