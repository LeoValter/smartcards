package ru.leovalter.smartcards.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.leovalter.smartcards.service.UserService;

@Controller
public class RootController {

    private final UserService service;

    public RootController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/admin")
    public String privateHome(ModelMap map) {
        map.addAttribute("users", service.getAll());
        return "users";
    }
}
