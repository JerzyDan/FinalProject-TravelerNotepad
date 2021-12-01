package com.ironhack.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()

                //Country Service
                .route(p -> p.path("/api/v1/country/**")
                        .uri("lb://COUNTRY-SERVICE"))
                .route(p ->p.path("/api/v1/country**")
                        .uri("lb://COUNTRY-SERVICE"))

                //Place Service
                .route(p -> p.path("/api/v1/places/**")
                        .uri("lb://PLACE-SERVICE"))
                .route(p ->p.path("/api/v1/places**")
                        .uri("lb://PLACE-SERVICE"))

                //Search Service
                .route(p -> p.path("/api/v1/search/**")
                        .uri("lb://SEARCH-SERVICE"))
                .route(p ->p.path("/api/v1/search**")
                        .uri("lb://SEARCH-SERVICE"))

                //Report Service
                .route(p -> p.path("/api/v1/report/**")
                        .uri("lb://REPORT-SERVICE"))
                .route(p ->p.path("/api/v1/report**")
                        .uri("lb://REPORT-SERVICE"))

                .build();
    }
}
