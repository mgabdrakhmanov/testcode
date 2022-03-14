package ru.marat.springdemo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.util.HtmlUtils;
import ru.marat.springdemo.helloworld.beans.DummyBean;
import ru.marat.springdemo.helloworld.model.Person;
import ru.marat.springdemo.helloworld.repository.PersonsRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HelloWorldController {

    private final DummyBean dummyBean;

    @Autowired
    public HelloWorldController(DummyBean aDummyBean, PersonsRepository aPersonsRepository){
        dummyBean = aDummyBean;
    }

    @RequestMapping
    public String helloWorld() {
        return dummyBean.responseHello();
    }

    @RequestMapping("/goodbye")
    public String goodbye() {
        return "Goodbye";
    }

}
