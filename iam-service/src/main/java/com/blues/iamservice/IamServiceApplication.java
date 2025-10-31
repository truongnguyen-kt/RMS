package com.blues.iamservice;

import com.blues.common.env.utils.EgovConfigUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IamServiceApplication {

    public static void main(String[] args) {
        EgovConfigUtil.d();
        SpringApplication.run(IamServiceApplication.class, args);
    }

}
