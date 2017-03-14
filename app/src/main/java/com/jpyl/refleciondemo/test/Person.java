package com.jpyl.refleciondemo.test;

/**
 * Created by dg on 2017/3/14.
 */

public interface Person {
    public String name();

    public int age();

    @Deprecated
    public void sing();
}
