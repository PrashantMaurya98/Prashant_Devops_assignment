package com.prashant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller

public class PrashantApplication {

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "This is a Java Static Web Application");
        model.addAttribute("msg", "Application Is Deployed To Apache Tomcat");
        return "index";
    }
}

