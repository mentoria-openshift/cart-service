package es.thalesalv.sigla.gateway.adapter.bean;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RouteLocatorBean {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        return builder.routes()
            .route("cart", r -> r.path("/cart/**")
                .filters(f -> f.hystrix(c -> c.setName("cartsFallback")
                    .setFallbackUri("forward:/carts-fallback")))
                .uri("lb://cart"))
            .build();
    }
}
