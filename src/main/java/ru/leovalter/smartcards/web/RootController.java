package ru.leovalter.smartcards.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String home() {
        return "welcome";
    }

    @GetMapping("/admin")
    public String privateHome() {
        return "users";
    }
}
