package demos.dummy;

public interface TestFunction {
    boolean test();

    // default method has to have implementation
    default boolean test1() {
        return false;
    }
}
