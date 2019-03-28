package com.daisihao.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.daisihao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
