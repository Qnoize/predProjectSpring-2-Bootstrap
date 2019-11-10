package ru.jmentor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.jmentor.model.User;
import ru.jmentor.service.UserService;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_admin')")
public class AdminController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/admin")
    public ModelAndView viewAdminPage(ModelAndView modelAndView) {
        List<User> users = service.getAllUsers();
        modelAndView.setViewName("adminMainPage");
        modelAndView.addObject("list", users);
        return modelAndView;
    }

    @PostMapping(value = "/admin")
    public ModelAndView adminCreateUser(
            @ModelAttribute("user") User user,
            ModelAndView modelAndView) {

        if (!user.getUserName().isEmpty()&& !user.getUserPassword().isEmpty()) { service.saveUser(user); }
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @PostMapping (value = "/admin/delete")
    public ModelAndView adminDeleteUser(
            @RequestParam("id") Long id,
            ModelAndView modelAndView) {

        modelAndView.setViewName("redirect:/admin");
        if (id != null) { service.deleteUserById(id); }
        return modelAndView;
    }

    @GetMapping(value = "/admin/edit")
    public ModelAndView adminEditPage(
            @RequestParam("id") Long id,
            @RequestParam("edit") String edit,
            ModelAndView modelAndView) {

        User user = null;
        if (edit != null && id != null) { user = service.getUserById(id); }
        modelAndView.addObject("userPassword", "");
        modelAndView.setViewName("adminEditUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = "/admin/edit")
    public ModelAndView adminEditUser(
            @ModelAttribute("user") User user,
            @RequestParam("userPassword") String newUserPassword,
            ModelAndView modelAndView) {
        if(newUserPassword.isEmpty()){
            modelAndView.addObject("error", "Error - Your password isEmpty! Enter new password");
            modelAndView.setViewName("adminEditUser");
        } else {
            user.setUserPassword(newUserPassword);
            service.editUser(user);
            modelAndView.setViewName("redirect:/admin");
        }
        return modelAndView;
    }
}
