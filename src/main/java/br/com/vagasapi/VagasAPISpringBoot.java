package br.com.vagasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableHystrix
@EnableAsync
public class VagasAPISpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(VagasAPISpringBoot.class, args);
    }
}
