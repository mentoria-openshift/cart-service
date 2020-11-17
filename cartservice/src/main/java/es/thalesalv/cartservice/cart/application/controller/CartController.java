package es.thalesalv.cartservice.cart.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.cartservice.cart.adapter.entity.CartEntity;
import es.thalesalv.cartservice.cart.adapter.mapper.Translator;
import es.thalesalv.cartservice.cart.adapter.repository.CartRepository;
import es.thalesalv.cartservice.cart.application.service.PricingService;
import es.thalesalv.cartservice.cart.domain.extension.CartNotFoundException;
import es.thalesalv.cartservice.cart.domain.model.Cart;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final Translator<Cart, CartEntity> entityToDtoTranslator;
    private final Translator<CartEntity, Cart> dtoToEntityTranslator;
    private final CartRepository repository;
    private final PricingService pricingService;

    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable Integer id) {

        CartEntity entity = repository.findById(id)
                .orElseThrow(() -> new CartNotFoundException("Cart not found: " + id));
                
        return entityToDtoTranslator.translate(entity);
    }

    @PostMapping("/cart")
    public Mono<Cart> saveCart(@RequestBody Cart cart) {

        return pricingService.price(cart).map(cartResponse -> {
            CartEntity entity = repository.save(dtoToEntityTranslator.translate(cartResponse));
            return entityToDtoTranslator.translate(entity);
        });
    }

    @GetMapping("/carts")
    public List<Cart> getCarts() {

        List<Cart> carts = new ArrayList<>();
        Iterable<CartEntity> entity = repository.findAll();
        entity.forEach(cartEntity -> {
            Cart cart = entityToDtoTranslator.translate(cartEntity);
            carts.add(cart);
        });

        return carts;
    }
}