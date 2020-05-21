package com.dario.dubboredis;


import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DubboredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboredisApplication.class, args);
        Main.main(args);
    }

}
