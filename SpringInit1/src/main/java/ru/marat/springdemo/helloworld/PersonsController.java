package ru.marat.springdemo.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.marat.springdemo.helloworld.model.Person;
import ru.marat.springdemo.helloworld.repository.PersonsRepository;

import java.util.stream.Collectors;

@Controller
public class PersonsController {

    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsController(PersonsRepository aPersonsRepository){
        personsRepository = aPersonsRepository;

    }

    @RequestMapping(path = "/person")
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello JSP");
        return "hello.jsp";
    }

    @RequestMapping("/person/list")
    public String persons() {
        return personsRepository
                .getAll()
                .stream()
                .map(Person::getName)
                .collect(Collectors.joining("<br>"));
    }

    @RequestMapping("/person/{id}")
    public String showPerson(@PathVariable("id") int id) {
        return personsRepository.show(id).getName();
    }
}
