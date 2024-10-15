package demos.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // CompletableFuture is asynchronously, to be completed by a task running in the ForkJoinPool.commonPool()
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::getNumber)
                .thenApply(result -> result * 2)
                .thenApply(result -> {
                    System.out.println(result);
                    try { Thread.sleep(10*1000); }
                    catch(Exception e) {}
                    return result + 5;
                })
                ;
        future.thenAcceptAsync(result -> System.out.println("Async: " + result));   // Async
        //System.out.println("With get():"+future.get());                 // Sync: block

        // Below line prints first, showing that CompletableFuture is async
        System.out.println("main thread");
        while (!future.isDone()) {
            try { Thread.sleep(1000); }
            catch(Exception e) {}
        }
    }

    private static int getNumber() {
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {}
        return 15;
    }
}
