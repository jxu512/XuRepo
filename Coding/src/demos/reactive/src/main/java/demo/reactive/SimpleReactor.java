package demo.reactive;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class SimpleReactor {
    public static void main(String[] args) {
        // Create a Flux that emits a series of strings
        Flux<String> stringFlux = Flux.just("Apple", "Banana", "Cherry", "Date", "Elderberry");
        Flux<String> moreFlux = Flux.just("Orange", "Peach", "Blue Berry");
        stringFlux.subscribeOn(Schedulers.parallel()).subscribe(s->{
            String name = Thread.currentThread().getName();
            System.out.println(name + ":" + s);
        });
        Flux<String> newFlux = Flux.concat(stringFlux, moreFlux);
        stringFlux.subscribe(s->{
            String name = Thread.currentThread().getName();
            System.out.println(name + " on newFlux:" + s);
        });

        try { Thread.sleep(10000); }
        catch (Exception e) {}
        /*
        ConnectableFlux connectableFlux = stringFlux.publish();
        connectableFlux.subscribe(System.out::println);
        connectableFlux.subscribeOn(Schedulers.parallel()).subscribe(s->{
            //System.out.println(Thread.currentThread().getName() + ":" + s);
        });
        connectableFlux.connect();
        */

        // Filter the Flux to only include strings that start with 'B'
        System.out.println("\nAfter filtering");
        Flux<String> filteredFlux = stringFlux.filter(s -> s.startsWith("B"));
        // Subscribe to the Flux and print each element
        filteredFlux.subscribe(System.out::println);
    }
}
