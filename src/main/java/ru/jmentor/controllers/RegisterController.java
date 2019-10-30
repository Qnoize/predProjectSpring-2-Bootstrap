package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.model.User;
import ru.jmentor.service.UserService;
import java.util.List;

@Controller
public class RegisterController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/register")
    public ModelAndView viewRegisterPage(ModelAndView modelAndView) {
        List<User> users = service.getAllUsers();
        modelAndView.setViewName("registerUser");
        modelAndView.addObject("list", users);
        return modelAndView;
    }

    @PostMapping(value = "/register")
    public ModelAndView registerNewUser(
            @ModelAttribute("user") User user,
            ModelAndView modelAndView) {
        if (user.getUserName().isEmpty() | user.getUserPassword().isEmpty()) {
            modelAndView.addObject("error", "Empty user Login or Password");
            modelAndView.setViewName("errorPage");
        } else {
            service.saveUser(user);
            modelAndView.setViewName("redirect:/register");
        }
        return modelAndView;
    }
}
