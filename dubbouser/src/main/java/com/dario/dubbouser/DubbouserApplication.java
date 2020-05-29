package com.dario.dubbouser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.dario.dubbouser.mapper")
public class DubbouserApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubbouserApplication.class, args);
	}


}
