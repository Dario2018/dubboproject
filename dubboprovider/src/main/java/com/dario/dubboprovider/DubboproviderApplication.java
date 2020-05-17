package com.dario.dubboprovider;

/**
* 相当于gaming-server-service-admin
* */
import com.alibaba.dubbo.container.Main;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dario.dubboprovider.mapper")
public class DubboproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboproviderApplication.class, args);
        Main.main(args);
    }

}
