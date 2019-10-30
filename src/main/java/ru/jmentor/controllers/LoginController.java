package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ModelAndView viewLoginPage(ModelAndView modelAndView) {
        modelAndView.setViewName("loginUser");
        return modelAndView;
    }

    @PostMapping(value = "/")
    public ModelAndView userAutorization(
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword,
            HttpSession session,
            ModelAndView modelAndView) {
        if(service.ExistUserByNameAndPassword(userName, userPassword)) {
            session.setAttribute("name", userName);
            String role = "user";
            if (service.getByName(userName).getRole().toString().contains("admin")) { role = "admin"; }
            session.setAttribute("role", role);
            if (role.equals("admin")) {
                modelAndView.setViewName("redirect:/admin");
                return modelAndView;
            }
            else {
                modelAndView.setViewName("redirect:/userHome");
                return modelAndView;
            }
        }
        modelAndView.addObject("error", "Wrong user Login or Password");
        modelAndView.setViewName("errorPage");

        return modelAndView;
    }
}
