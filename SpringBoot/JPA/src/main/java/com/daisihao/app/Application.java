package com.daisihao.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.daisihao")
@EntityScan(basePackages = "com.daisihao.pojo")//扫描实体类
@EnableJpaRepositories(basePackages = "com.daisihao.dao")//扫描Dao类
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
