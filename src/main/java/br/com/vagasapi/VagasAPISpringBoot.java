package br.com.vagasapi;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableAdminServer
public class VagasAPISpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(VagasAPISpringBoot.class, args);
    }
}
