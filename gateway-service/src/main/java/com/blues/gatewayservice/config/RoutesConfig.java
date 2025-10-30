package com.blues.gatewayservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class RoutesConfig {
    private final DiscoveryClient discoveryClient;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        List<String> serviceList = discoveryClient.getServices();
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();

        serviceList.forEach(service -> {
            routesBuilder.route(service, r -> r
                    .path("/" + service + "/**") // prefix route theo service
                    .uri("lb://" + service)      // load-balancing với lb://
            );
        });
        return routesBuilder.build();
    }
}
