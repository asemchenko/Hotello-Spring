package company.example.controller;

import company.example.model.entity.User;
import company.example.model.entity.UserRole;
import company.example.model.repos.UserRepo;
import company.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userService.findByUsername(user.getUsername());
        if (userFromDb != null) {
            model.addAttribute("message", "User with such username already exists");
            return "registration";
        }
        user.setActive(true);
        user.setRole(UserRole.CLIENT);
        userService.save(user);
        return "redirect:/login";
    }
}