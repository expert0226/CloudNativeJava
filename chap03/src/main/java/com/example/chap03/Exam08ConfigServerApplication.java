package com.example.chap03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// https://spring.io/guides/gs/centralized-configuration/
@SpringBootApplication
@EnableConfigServer
public class Exam08ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Exam08ConfigServerApplication.class);
    }
}