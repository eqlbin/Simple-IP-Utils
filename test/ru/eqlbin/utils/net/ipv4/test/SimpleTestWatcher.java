package ru.eqlbin.utils.net.ipv4.test;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SimpleTestWatcher extends TestWatcher {

    public SimpleTestWatcher() {}

    @Override
    protected void succeeded(Description description) {
        System.out.println("OK: " + description.getMethodName());
    }
    
    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("FAILED: " + description.getMethodName());
    }
}
