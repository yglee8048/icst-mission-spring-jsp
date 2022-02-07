package com.lgcns.icst.mission.spring.jsp.hangma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class HangmaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HangmaApplication.class, args);
    }

}
