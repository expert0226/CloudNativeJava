package com.example.exam04;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("some.properties")
public class Exam04EnvApplication {
    private final Log log = LogFactory.getLog(getClass());

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Exam04EnvApplication.class);
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer pspc() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${configuration.projectName}")
    private String fieldValue;

    @Autowired
    Exam04EnvApplication(@Value("${configuration.projectName}") String pn) {
        log.info("Application constructor: " + pn);
    }

    @Value("${configuration.projectName}")
    void setProjectName(String projectName) {
        log.info("setProjectName: " + projectName);
    }

    @Autowired
    void setEnvironment(Environment env) {
        log.info("setEnvironment: " + env.getProperty("configuration.projectName"));
    }

    @Bean
    InitializingBean both(Environment env, @Value("${configuration.projectName}") String projectName) {
        return () -> {
            log.info("@Bean with both dependencies (projectName): " + projectName);
            log.info("@Bean with both dependencies (env): " + env.getProperty("configuration.projectName"));
        };
    }

    @PostConstruct
    void afterPropertiesSet() throws Throwable {
        log.info("fieldValue: " + this.fieldValue);
    }
}
