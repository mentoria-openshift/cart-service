package es.thalesalv.sigla.cartservice.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.sigla.cartservice.domain.model.Cart;
import reactor.core.publisher.Flux;

@RestController
public class CartsFallbackController {

    @GetMapping("/carts-fallback")
    public Flux<Cart> noCars() {
        return Flux.empty();
    }
}
