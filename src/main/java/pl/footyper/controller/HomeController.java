package pl.footyper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.footyper.model.UserEntity;
import pl.footyper.repository.UserRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "HOme page";
    }

    @RequestMapping("/users")
    @ResponseBody

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/add")
    @ResponseBody
    public UserEntity addUser() {
        UserEntity u = new UserEntity();
        u.setId(1L);
        u.setLogin("bm");
        u.setPassword("pass");
        return userRepository.saveAndFlush(u);
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name + "lll");
        return "hello";
    }


    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login() {
        return "login";
    }
}
