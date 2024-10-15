package demos.threading.completable;

import java.util.function.Supplier;

public class FuncC implements Supplier<String> {
    @Override
    public String get() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {

        }
        return "From function C";
    }
}
