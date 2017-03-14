package com.jpyl.refleciondemo.test;

/**
 * Created by dg on 2017/3/14.
 */

public class Test {
    @SuppressWarnings("deprecation")
    public void sing() {
        Person child = new Child();
        child.sing();
    }
}
