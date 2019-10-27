package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.model.User;
import ru.jmentor.service.UserService;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ModelAndView viewLoginPage() { return new ModelAndView("loginUser"); }

    @PostMapping(value = "/")
    public ModelAndView userAutorization(
            @RequestParam("userName") String userName,
            @RequestParam("userPassword") String userPassword,
            HttpSession session) {
        if(service.ExistUserByNameAndPassword(userName, userPassword)) {
            session.setAttribute("name", userName);
            String role = "user";
            if (service.getByName(userName).getRole().toString().contains("admin")) { role = "admin"; }
            session.setAttribute("role", role);
            if (role.equals("admin")) { return new ModelAndView("redirect:/admin"); }
            else { return new ModelAndView("redirect:/userHome"); }
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping(value = "/admin")
    public ModelAndView viewAdminPage() {
        List<User> users = service.getAllUsers();
        return new ModelAndView("adminMainPage", "list", users);
    }

    @PostMapping(value = "/admin")
    public ModelAndView adminCreateUser(
            @ModelAttribute("user") User user) {
        if (!user.getUserName().isEmpty()&& !user.getUserPassword().isEmpty()) { service.saveUser(user); }
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping(value = "/admin/delete")
    public ModelAndView adminDeleteUser(
            @RequestParam("id") Long id,
            @RequestParam("delete") String delete) {
        if (delete != null && id != null) { service.deleteUserById(id); }
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping(value = "/admin/edit")
    public ModelAndView editPage(
            @RequestParam("id") Long id,
            @RequestParam("edit") String edit) {
        User user = null;
        if (edit != null && id != null) { user = service.getUserById(id); }
        return new ModelAndView("adminEditUser", "user", user);
    }

    @PostMapping(value = "/admin/edit")
    public ModelAndView adminEditUser(
            @ModelAttribute("user") User user) {
        service.editUser(user);
        return new ModelAndView("redirect:/admin");
    }

    @GetMapping(value = "/register")
    public ModelAndView viewRegisterPage() {
        List<User> users = service.getAllUsers();
        return new ModelAndView("registerUser", "list", users);
    }

    @PostMapping(value = "/register")
    public ModelAndView registerNewUser(
            @ModelAttribute("user") User user) {
        if (!user.getUserName().isEmpty()&& !user.getUserPassword().isEmpty()) { service.saveUser(user); }
        return new ModelAndView("redirect:/register");
    }

    @GetMapping(value = "/userHome")
    public ModelAndView viewUserHomePage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", session.getAttribute("name"));
        modelAndView.addObject("role", session.getAttribute("role"));
        modelAndView.setViewName("userHome");
        return modelAndView;
    }
    @PostMapping(value = "/userHome")
    public ModelAndView userHomePage() { return new ModelAndView("loginUser"); }
}
