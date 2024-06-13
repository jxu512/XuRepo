package demos.basics.extent;

import demos.basics.common.BaseClass;

public class ParentClass extends BaseClass {

    //@Override     // Can't override private method
    private void privateMethod() {

    }
    @Override
    protected void protectedMethod() {

    }
    @Override
    public void publicMethod() {

    }
    //@Override           // Can't access method with default modifier which is for access in same package
    void defaultMethod() {

    }
}
