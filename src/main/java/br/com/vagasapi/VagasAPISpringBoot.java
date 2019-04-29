package br.com.vagasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VagasAPISpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(VagasAPISpringBoot.class, args);
    }
}
