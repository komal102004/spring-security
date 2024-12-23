package com.spring.security.springSecurity.authentication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {
    @GetMapping("/login")
    public String login()
    {
        return "login";
    }
}
