package com.example.exam10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class Exam11ProjectNameRestController {
    private final String projectName;

    @Autowired
    public Exam11ProjectNameRestController(
            @Value("${configuration.projectName}") String pn
    ) {
        this.projectName = pn;
    }

    @RequestMapping("/project-name")
    String projectName() {
        return this.projectName;
    }

    public static void main(String[] args) {
        SpringApplication.run(Exam11ProjectNameRestController.class, args);
    }
}
