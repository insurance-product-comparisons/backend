package ru.ya.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.ya.insurance.mapper")
public class InsuranceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceProjectApplication.class, args);
    }

}
