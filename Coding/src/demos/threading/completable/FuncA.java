package demos.threading.completable;

import java.util.function.Supplier;

public class FuncA implements Supplier<String> {
    @Override
    public String get() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
        return "From function A";
    }
}
