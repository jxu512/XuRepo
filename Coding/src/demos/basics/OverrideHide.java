package demos.basics;

import java.util.ArrayList;
import java.util.List;

public class OverrideHide extends ParentCls{
    //void method1() {
    static void method1() {
        System.out.println("From child");
        ParentCls.method1();
    }
    @Override
    protected List<String> method2() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        OverrideHide.method1();
        OverrideHide.method3();
        ParentCls.method3();
        OverrideHide staticOverride = new OverrideHide();
        staticOverride.method1();
    }
}

class ParentCls {
    static void method1() {
        System.out.println("From parent");
    }
    static void method3() {
        System.out.println("From parent");
    }

    protected List<String> method2() {
        return new ArrayList<>();
    }
}