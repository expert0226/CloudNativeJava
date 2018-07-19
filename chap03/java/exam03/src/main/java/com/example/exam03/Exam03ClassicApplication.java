package com.example.exam03;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Exam03ClassicApplication {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classic.xml");
    }

    public void setConfigurationProjectName(String pn) {
        LogFactory.getLog(getClass()).info("the configuration project name is " + pn);
    }
}
