package demos.threading.completable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.function.Supplier;

public class ServiceProcessor {

    public void process() {
        List<String> results = new ArrayList<>();

        List<Supplier> suppliers = List.of(new FuncA(), new FuncB(), new FuncC());
        CountDownLatch latch = new CountDownLatch(suppliers.size());
        suppliers.forEach(supplier -> {
            CompletableFuture future = CompletableFuture
                    .supplyAsync(supplier)
                    .thenAcceptAsync(res->{
                        synchronized (results) {
                            results.add((String) res);
                        }
                        latch.countDown();
                        System.out.println((new Date()).toString() + ": done with " + supplier.getClass());
                    });
        });

        try {
            latch.await();
            System.out.println((new Date()).toString() + ": " + results);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServiceProcessor processor = new ServiceProcessor();
        processor.process();
    }
}
