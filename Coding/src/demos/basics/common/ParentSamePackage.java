package demos.basics.common;

public class ParentSamePackage extends BaseClass {

    //@Override     // Can't override private method
    private void privateMethod() {

    }
    @Override
    protected void protectedMethod() {

    }
    @Override
    public void publicMethod() {

    }
    @Override           // Can override method with default modifier same package
    void defaultMethod() {

    }
}
