package es.thalesalv.sigla.cartservice.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.sigla.cartservice.adapter.entity.CartEntity;
import es.thalesalv.sigla.cartservice.adapter.mapper.Translator;
import es.thalesalv.sigla.cartservice.adapter.repository.CartRepository;
import es.thalesalv.sigla.cartservice.domain.extension.CartNotFoundException;
import es.thalesalv.sigla.cartservice.domain.model.Cart;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final Translator<Cart, CartEntity> entityToDtoTranslator;
    private final Translator<CartEntity, Cart> dtoToEntityTranslator;
    private final CartRepository repository;

    @GetMapping("/cart/{id}")
    public Cart getCart(@PathVariable Integer id) {

        CartEntity entity = repository.findById(id)
                .orElseThrow(() -> new CartNotFoundException("Cart not found: " + id));
                
        return entityToDtoTranslator.translate(entity);
    }

    @PostMapping("/cart")
    public Cart saveCart(@RequestBody Cart cart) {

        CartEntity entity = repository.save(dtoToEntityTranslator.translate(cart));
        return entityToDtoTranslator.translate(entity);
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