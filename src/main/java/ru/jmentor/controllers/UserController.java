package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/userHome")
    public ModelAndView viewUserHomePage(
            HttpSession session,
            ModelAndView modelAndView) {

        modelAndView.addObject("name", session.getAttribute("name"));
        modelAndView.addObject("role", session.getAttribute("role"));
        modelAndView.setViewName("userHome");
        return modelAndView;
    }
    @PostMapping(value = "/userHome")
    public ModelAndView userHomePage(ModelAndView modelAndView) {

        modelAndView.setViewName("loginUser");
        return modelAndView;
    }
}
