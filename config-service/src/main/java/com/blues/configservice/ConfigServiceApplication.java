package com.blues.configservice;

import com.blues.common.env.utils.EgovConfigUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServiceApplication {

    public static void main(String[] args) {
        EgovConfigUtil.d();
        SpringApplication.run(ConfigServiceApplication.class, args);
    }

}
