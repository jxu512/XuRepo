package demos.basics;

import java.io.*;

public class SerilizationTest {
    public static void main(String[] args) throws Exception {
        SerilizationTest serilizationTest = new SerilizationTest();
        serilizationTest.test();
    }

    public void test() throws Exception {
        String path = "c:/tmp/persons.dat";
        Person p1 = new Person(1, 18, "Jeff");
        Person p2 = new Person(2, 28, "Jack");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(path)));
        objectOutputStream.writeObject(p1);
        objectOutputStream.writeObject(p2);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(path)));
        Person p3, p4;
        p3 = (Person)objectInputStream.readObject();
        p4 = (Person)objectInputStream.readObject();
        System.out.format("p3: %s, p4:%s\n", p3, p4);
    }
}
// Must implements Serializable to indicate it is serializable, even it does not override any method
class Person implements Serializable {
    int id, age;
    String name;
    static String relation = "relation";        // static filed is transient but every object has it

    // Use transient to exclude fields from serialization
    //transient
    InternalState state = new InternalState();

    public Person(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
    public String toString() {
        return id + ":" + age + ":" + name + ":" + relation + ":" + state;
    }
}
class InternalState implements Serializable
{
    private int id = 100;
    public String toString() {
        return "State: " + id;
    }
}