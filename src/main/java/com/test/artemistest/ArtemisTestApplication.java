package com.test.artemistest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ArtemisTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtemisTestApplication.class, args);
    }

}

