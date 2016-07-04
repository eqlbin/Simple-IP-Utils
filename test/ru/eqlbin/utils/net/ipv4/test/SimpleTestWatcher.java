package ru.eqlbin.utils.net.ipv4.test;

import java.util.Arrays;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class SimpleTestWatcher extends TestWatcher {

    public SimpleTestWatcher() {}

    @Override
    protected void succeeded(Description description) {
        System.out.println(
                String.format("%-6s [%s]: %s", 
                        "OK",
                        description.getTestClass().getSimpleName(),
                        description.getMethodName())
        );
    }
    
    @Override
    protected void failed(Throwable e, Description description) {
        
        System.out.println(
                String.format("%-6s [%s]: %s --> %s", 
                        "FAILED",
                        description.getTestClass().getSimpleName(),
                        description.getMethodName(),
                        e)
        );
    }
}
