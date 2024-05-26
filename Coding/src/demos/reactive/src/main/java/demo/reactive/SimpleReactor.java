package demo.reactive;

import reactor.core.publisher.Flux;

public class SimpleReactor {
    public static void main(String[] args) {
        // Create a Flux that emits a series of strings
        Flux<String> stringFlux = Flux.just("Apple", "Banana", "Cherry", "Date", "Elderberry");

        // Filter the Flux to only include strings that start with 'B'
        Flux<String> filteredFlux = stringFlux.filter(s -> s.startsWith("B"));

        // Subscribe to the Flux and print each element
        filteredFlux.subscribe(System.out::println);
    }
}
