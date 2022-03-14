package ru.marat.springdemo.helloworld.beans;

import org.springframework.stereotype.Component;

@Component
public class DummyBean {

    public String responseHello() {
        return "Hello from Dummy Bean";
    }

}
