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

        Arrays.asList(fruits).stream().forEach(fruit->publisher.submit(fruit));
        publisher.close();

        // Wait for subscriber to complete
        while (!subscriber.isCompleted()) Thread.sleep(1000);
    }
}

class FruitSubscriber<String> implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    private boolean completed = false;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscribed...");
        this.subscription = subscription;
        this.subscription.request(3);
    }

    @Override
    public void onNext(Object item) {
        System.out.println("Processing " + item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
        completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }
}