package ru.ya.insurance.osago.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;
import ru.ya.insurance.InsuranceProjectApplication;

@TestConfiguration(proxyBeanMethods = false)
public class TestInsuranceProjectApplication {

    public static void main(String[] args) {
        SpringApplication.from(InsuranceProjectApplication::main).with(TestInsuranceProjectApplication.class).run(args);
    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));
    }

}
