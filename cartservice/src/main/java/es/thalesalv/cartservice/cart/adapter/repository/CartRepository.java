package es.thalesalv.cartservice.cart.adapter.repository;

import org.springframework.data.repository.CrudRepository;

import es.thalesalv.cartservice.cart.adapter.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
    
}
