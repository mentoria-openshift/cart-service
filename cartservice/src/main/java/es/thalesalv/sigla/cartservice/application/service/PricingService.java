package es.thalesalv.sigla.cartservice.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import es.thalesalv.sigla.cartservice.domain.extension.PricingException;
import es.thalesalv.sigla.cartservice.domain.model.Cart;
import es.thalesalv.sigla.cartservice.domain.model.LineItem;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PricingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PricingService.class);

    private final WebClient webClient;

    public Mono<Cart> price(Cart cart) {
        return webClient.post()
            .bodyValue(cart)
            .retrieve()
            .onStatus(HttpStatus::is5xxServerError, response -> {
                LOGGER.error("Error retrieving pricing data. Status code -> {}", response.statusCode().value());
                return Mono.error(new PricingException("Error retrieving pricing data. Status code -> " 
                        + response.statusCode().value()));
            })
            .bodyToMono(Cart.class).map(priced -> {
                priced.getLineItems().stream()
                .forEach(line -> {
                    final int indexOfCart = priced.getLineItems().indexOf(line);
                    LineItem pricedLineItem = priced.getLineItems().get(indexOfCart);
                    LineItem lineItem = cart.getLineItems().get(indexOfCart);
                    lineItem.setPrice(pricedLineItem.getPrice());
                });

                cart.setTotal(priced.getTotal());
                return cart;
            });
    }
}
