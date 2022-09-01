package com.tuts;

import com.tuts.service.JoinUserAddress;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootApacheFlinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApacheFlinkApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(JoinUserAddress joinUserAddress) {
        return args -> joinUserAddress.joinUserAndAddress().forEach(System.out::println);
    }
}
