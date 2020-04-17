package com.fern.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fern.vhr.mapper")
public class VhrV2Application {

    public static void main(String[] args) {
        SpringApplication.run(VhrV2Application.class, args);
    }

}
