package demos.threading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    public static void main(String[] args) {

        // CompletableFuture is asynchronously, to be completed by a task running in the ForkJoinPool.commonPool()
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenApplyAsync(result -> result * 2)
                .thenApplyAsync(result -> {
                    try { Thread.sleep(10*1000); }
                    catch(Exception e) {}
                    return result + 5;
                });

        future.thenAccept(result -> System.out.println(result));

        // Below line prints first, showing that CompletableFuture is async
        System.out.println("main thread");
        while (!future.isDone()) {
            try { Thread.sleep(1000); }
            catch(Exception e) {}
        }
    }
}
