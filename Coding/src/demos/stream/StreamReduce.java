package demos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamReduce {

    public static void main(String[] args) {
        StreamReduce reduce = new StreamReduce();
        reduce.testReduce();
    }
    private void testReduce () {
        List<List<String>> fruits = new ArrayList<>();
        fruits.add(List.of("Apple", "Orange"));
        fruits.add(List.of("Kiwi", "Banana"));
        fruits.add(List.of("Pear", "Blueberry"));

        System.out.print("forEach: ");
        fruits.stream().forEach(list->list.forEach(f->System.out.print(f+",")));

        System.out.println();
        System.out.print("Reduce to string serial: ");
        System.out.println(fruits.stream().reduce("", (a,b)->a+String.join(",",b)+";", (x,y)->null));   // combiner is not used for serial

        System.out.print("Reduce to string parallel: ");
        System.out.println(fruits.parallelStream().reduce("", (a,b)->a+String.join(",",b)+";", (x,y)->x + y));  // combiner is needed for parallel

        System.out.print("Flatmap: ");
        System.out.println(fruits.stream().flatMap(li-> Stream.of(li.toArray(new String[0]))).reduce("", (a,b)->a+b+","));

        List<String> list = fruits.stream().reduce(new ArrayList<>(), (a,b)->{a.addAll(b);return a;});
        System.out.print("Reduce to List<>...1: ");
        list.forEach(fruit->System.out.print(fruit+","));

        Optional<List<String>> optional =
                fruits.stream().reduce((a,b)->{
                    List<String> li = new ArrayList<>();
                    li.addAll(a);
                    li.addAll(b);
                    return li;
                });
        System.out.println();
        System.out.print("Reduce to List<>...2: ");
        optional.get().forEach(fruit->System.out.print(fruit+","));

    }
}
