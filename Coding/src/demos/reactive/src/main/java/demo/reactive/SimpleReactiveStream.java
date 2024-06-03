package demo.reactive;

import java.util.Arrays;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class SimpleReactiveStream {

    public static void main(String[] args) throws InterruptedException {

        String[] fruits = { "Apple", "Banana", "Cherry", "Date", "Elderberry" };
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        FruitSubscriber subscriber = new FruitSubscriber<>();
        publisher.subscribe(subscriber);

        int n = 1000;
        for (int i=0;i<n;i++)
            Arrays.asList(fruits).stream().forEach(publisher::submit);
        System.out.println("\nPublished: " + fruits.length * n);
        publisher.close();

        // Wait for subscriber to complete
        while (!subscriber.isCompleted()) {
            System.out.println("Waiting for consumer to complete...");
            Thread.sleep(100);
        }
    }
}

class FruitSubscriber<String> implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    private boolean completed = false;
    private int count;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed...");
        this.subscription = subscription;
        this.subscription.request(3);
    }

    @Override
    public void onNext(Object item) {
        System.out.print(item + ",");
        this.subscription.request(1);
        count++;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed: " + count);
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}