package com.example.postgresproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.postgresproduct")
public class PostgresProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresProductApplication.class, args);
    }

}
