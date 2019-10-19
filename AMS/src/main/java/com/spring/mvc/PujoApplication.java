package com.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * 
 * @author Soumyadip Chowdhury
 * @github soumyadip007
 *
 */
@SpringBootApplication
@EnableAsync
@ComponentScan({"com.spring.*"})
@EntityScan("com.spring.*")
@EnableJpaRepositories("com.spring.*")
public class PujoApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PujoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(PujoApplication.class);
    }
}

