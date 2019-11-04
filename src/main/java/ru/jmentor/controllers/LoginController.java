package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/login")
    public ModelAndView viewLoginPage(
            Authentication authentication,
            ModelAndView modelAndView,
            HttpServletRequest request) {
        if(authentication != null){
            modelAndView.setViewName("redirect:/userHome");
        }
        if(request.getParameterMap().containsKey("error")){
            modelAndView.addObject("error", "Wrong user Login or Password(GET)");
        }
        modelAndView.setViewName("loginUser");
        return modelAndView;
    }
}
