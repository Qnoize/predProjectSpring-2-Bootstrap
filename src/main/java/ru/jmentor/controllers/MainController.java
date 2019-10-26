package ru.jmentor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.model.User;
import ru.jmentor.service.UserServiceImpl;
import java.util.List;

@Controller
public class MainController {

    private UserServiceImpl service;

    @GetMapping(value = "/")
    public ModelAndView viewLoginPage() { return new ModelAndView("loginUser"); }

    @PostMapping(value = "/")
    public String userAutorization(
            @RequestParam("login") String userName,
            @RequestParam("password") String userPassword) {
        String role = "user";
        if(service.getByName(userName).getRole().toString().contains("admin")){
            role = "admin";
        }
        if(!role.equals("admin")) {
            return "adminMainPage";
        } else {
            return "userHome";
        }
    }

    @GetMapping(value = "/admin")
    public ModelAndView viewAdminPage() {
        List<User> users = service.getAllUsers();
        return new ModelAndView("adminMainPage", "list", users);
    }

    @PostMapping(value = "/admin")
    public String adminCreateUser(
            @RequestParam("login") String userName,
            @RequestParam("password") String userPassword,
            @RequestParam("email") String userEmail) {
        if (!userName.isEmpty()&& !userPassword.isEmpty()) {
            User user = new User(userName, userPassword, userEmail);
            service.saveUser(user);
        }
        return "adminMainPage";
    }

    @GetMapping(value = "/admin/delete")
    public String adminDeleteUser(
            @RequestParam("userId") Long userId,
            @RequestParam("delete") String delete) {
        if (delete != null && userId != null) {
            service.deleteUserById(userId);
        }
        return "/adminMainPage";
    }

    @GetMapping(value = "/admin/edit")
    public ModelAndView editPage(
            @RequestParam("userId") Long userId,
            @RequestParam("edit") String edit,
            Model model) {
        User user = null;
        if (edit != null && userId != null) {
            user = service.getUserById(userId);
        }
        return new ModelAndView("adminEditUser", "user", user);
    }

    @PostMapping(value = "/admin/edit")
    public ModelAndView adminEditUser(
            @RequestParam("userId") Long userId,
            @RequestParam("login") String userName,
            @RequestParam("password") String userPassword,
            @RequestParam("email") String userEmail) {
        User user = new User(userId, userName, userPassword, userEmail);
        service.editUser(user);
        return new ModelAndView("adminMainPage");
    }

    @GetMapping(value = "/register")
    public ModelAndView viewRegisterPage() {
        List<User> users = service.getAllUsers();
        return new ModelAndView("registerUser", "list", users);
    }

    @PostMapping(value = "/register")
    public ModelAndView registerNewUser(
            @RequestParam("login") String userName,
            @RequestParam("password") String userPassword,
            @RequestParam("email") String userEmail) {
        if (!userName.isEmpty()&& !userPassword.isEmpty()) {
            User user = new User(userName, userPassword, userEmail);
            service.saveUser(user);
        }
        return new ModelAndView("loginUser");
    }

    @GetMapping(value = "userHome")
    public ModelAndView viewUserHomePage() { return new ModelAndView("userHome"); }
}
