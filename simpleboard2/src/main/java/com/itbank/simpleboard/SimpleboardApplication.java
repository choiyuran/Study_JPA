package com.itbank.simpleboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing              // 자동으로 시간을 넣어줄 때
public class SimpleboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleboardApplication.class, args);
    }

}
