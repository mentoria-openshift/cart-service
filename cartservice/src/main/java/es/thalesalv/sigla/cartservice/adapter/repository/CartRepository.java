package es.thalesalv.sigla.cartservice.adapter.repository;

import org.springframework.data.repository.CrudRepository;

import es.thalesalv.sigla.cartservice.adapter.entity.CartEntity;

public interface CartRepository extends CrudRepository<CartEntity, Integer> {
    
}
