package ru.marat.springdemo.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloWorldController {

    private final DummyBean dummyBean;

    @RequestMapping
    public String helloWorld() {
        return dummyBean.responseHello();
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye";
    }

}
