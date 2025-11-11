package com.blues.iamservice;

import com.blues.common.env.utils.EgovConfigUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
public class IamServiceApplication {

    public static void main(String[] args) {
        EgovConfigUtil.d();
        SpringApplication.run(IamServiceApplication.class, args);
    }

}
