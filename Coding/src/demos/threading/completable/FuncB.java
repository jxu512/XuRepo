package demos.threading.completable;

import java.util.function.Supplier;

public class FuncB implements Supplier<String> {
    @Override
    public String get() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        return "From function B";
    }
}
