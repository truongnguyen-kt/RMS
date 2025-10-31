package com.blues.discoveryservice;

import com.blues.common.env.utils.EgovConfigUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

    public static void main(String[] args) {
        EgovConfigUtil.d();
        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

}
