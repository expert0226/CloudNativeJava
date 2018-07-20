package com.example.exam08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// 참고: https://spring.io/guides/gs/centralized-configuration/
// 사무실에서는 LoopBack 127.0.0.1 / localhost 안 됨. Read IP 접속 요망
// http://192.168.2.87:8888/configuration-client/master
@SpringBootApplication
@EnableConfigServer
public class Exam08ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Exam08ConfigServerApplication.class);
    }
}