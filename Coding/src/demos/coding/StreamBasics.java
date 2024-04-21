package demos.coding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {

    List<String> list;
    List<Student> students;
    public static void main(String[] args) {

        StreamBasics streamBasics = new StreamBasics();
        streamBasics.test();
    }

    public StreamBasics () {
        String[] arrays = {"David", "Jack", "Frank", "Jeffrey", "Jim", "Jack", "Frank"};
        list = Arrays.asList(arrays);
        System.out.println("List: " + list);

        students = new ArrayList<>();
        students.add(new Student("David", "Math", 90));
        students.add(new Student("Frank", "Math", 92));
        students.add(new Student("Jim", "Math", 86));
        students.add(new Student("Jeff", "Math", 80));
        students.add(new Student("Brian", "Math", 95));
        students.add(new Student("Liz", "Math", 87));
        students.add(new Student("Jen", "Math", 68));
        students.add(new Student("Jesse", "Math", 60));
        students.add(new Student("Jessica", "Math", 55));
        students.add(new Student("Emma", "Math", 62));
        students.add(new Student("David", "English", 90));
        students.add(new Student("Frank", "English", 92));
        students.add(new Student("Jim", "English", 86));
        students.add(new Student("Jeff", "English", 80));
        students.add(new Student("Brian", "English", 95));
        students.add(new Student("Liz", "English", 87));
        students.add(new Student("Jen", "English", 68));
        students.add(new Student("Jesse", "English", 60));
        students.add(new Student("Jessica", "English", 55));
        students.add(new Student("Emma", "English", 62));
        students.add(new Student("David", "Physics", 90));
        students.add(new Student("Frank", "Physics", 92));
        students.add(new Student("Jim", "Physics", 86));
        students.add(new Student("Jeff", "Physics", 80));
        students.add(new Student("Brian", "Physics", 95));
        students.add(new Student("Liz", "Physics", 87));
        students.add(new Student("Jen", "Physics", 68));
        students.add(new Student("Jesse", "Physics", 60));
        students.add(new Student("Jessica", "Physics", 55));
        students.add(new Student("Emma", "Physics", 62));
    }
    private void test() {
        System.out.println("allMatch: " + list.stream().allMatch(n -> n.length()>2));
        System.out.println("anyMatch: " + list.stream().anyMatch(n -> n.length()>6));
        System.out.println("anyMatch: " + list.stream().anyMatch(n -> n.length()>7));
        System.out.println("noneMatch: " + list.stream().noneMatch(n -> n.length()>5));
        System.out.println("noneMatch: " + list.stream().noneMatch(n -> n.length()>10));

        System.out.println("Filter/collect: " + list.stream()
                .distinct()
                .filter(n->n.length()>3).collect(Collectors.toCollection(TreeSet::new)));

        System.out.println("concatenate: " +
                Stream.concat(list.stream(),
                        list.stream().filter(n -> n.length() > 4).map(n -> n + " Honored"))
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList()));

        System.out.println("findany: " + list.stream().findAny().get());
        System.out.println("flatMap: " + list.stream()
                .flatMap(n -> n.length() > 4 ? Stream.of(n, n + " Honored") : Stream.of(n))
                .distinct()
                .collect(Collectors.toList()));

        System.out.print("forEach: "); list.stream().distinct().sorted().forEach(n -> System.out.print(n + ", "));
        System.out.println();

        // Infinite stream with short-circuit operation limit(): Non-short-circuit operation consumes infinite stream
        System.out.println("generate: " + Stream.generate(() -> (int)(Math.random()*10)).limit(10).collect(Collectors.toList()));
        System.out.println("iterate: " + Stream.iterate(0, i -> i + 1).limit(10).collect(Collectors.toList()));

        Optional<Integer> max = Stream.generate(() -> (int) (Math.random() * 10)).limit(10).max(Integer::compareTo);
        System.out.println("min/max: " + (max.isPresent() ? max.get() : "Not available"));

        System.out.println("\npeek: " + list.stream()
                .filter(s -> s.length() > 4)
                .peek(s -> System.out.printf("Filtered %s,", s))
                .map(String::toUpperCase)
                .peek(s -> System.out.printf("Mapped %s, ", s))
                .collect(Collectors.toList()));

        System.out.println("\nreduce as count: " + Stream.iterate(0, i -> i + 1).limit(10).peek(n->System.out.printf(n + ", ")).reduce(0, (a,b)->a+1));
        // 3rd arg combiner has no effect / not needed for same type reduction
        System.out.println("\nreduce as sum: " + Stream.iterate(0, i -> i + 1).limit(10).peek(n->System.out.printf(n + ", ")).reduce(0, Integer::sum));
        System.out.println("\nreduce as sum: " + Stream.iterate(0, i -> i + 1).limit(10).peek(n->System.out.printf(n + ", ")).reduce(0, Integer::sum, Integer::sum));
        System.out.println("\nreduce as sum: " + Stream.iterate(0, i -> i + 1).limit(10).peek(n->System.out.printf(n + ", ")).reduce((a,b)->a+b).get());

        // groupingby
        Map<String, List<Student>> map = students.stream()
                .sorted()
                .collect(Collectors.groupingBy(Student::getName));
        map = students.stream()
                .sorted()
                .collect(Collectors.groupingByConcurrent(Student::getName));
        System.out.println("groupingBy:" + map);
        System.out.println("groupingBy:" + students.stream()
                .sorted()
                .collect(Collectors.groupingBy(Student::getName, Collectors.counting())));

        // partitioningby
        System.out.println("partitioningBy:" + students.stream()
                        .sorted()
                        .collect(Collectors.partitioningBy(s -> s.getGrade() > 70)));
        System.out.println("partitioningBy:" + students.stream()
                .sorted()
                .collect(Collectors.partitioningBy(s -> s.getGrade() > 70, Collectors.counting())));

        System.out.println("joining:" + students.stream().sorted().map(Student::toString).collect(Collectors.joining(", ")));
        System.out.println("maxBy:" + students.stream().collect(Collectors.maxBy((s1,s2)->Integer.compare(s1.getGrade(),s2.getGrade()))));

    }
}

class Student implements Comparable<Student>{
    private String name;
    private String course;
    private int grade;

    public Student(String name, String course, int grade) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public String toString() {
        return name + ": " + course + ": " + grade;
    }

    @Override
    public int compareTo(Student o) {
        boolean sameName = name.compareTo(((Student) o).getName()) == 0;
        return sameName ?
                course.compareTo(((Student) o).getCourse())
                :
                name.compareTo(((Student) o).getName());
    }
}