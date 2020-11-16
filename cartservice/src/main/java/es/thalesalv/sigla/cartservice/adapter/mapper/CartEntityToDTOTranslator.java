package es.thalesalv.sigla.cartservice.adapter.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.thalesalv.sigla.cartservice.adapter.entity.CartEntity;
import es.thalesalv.sigla.cartservice.adapter.entity.LineItemEntity;
import es.thalesalv.sigla.cartservice.domain.model.Cart;
import es.thalesalv.sigla.cartservice.domain.model.LineItem;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CartEntityToDTOTranslator implements Translator<Cart, CartEntity> {

    private final Translator<LineItem, LineItemEntity> lineItemEntityToDTOTranslator;

    @Override
    public Cart translate(CartEntity input) {

        List<LineItem> lineItems = new ArrayList<>();
        input.getLineItems().forEach(lineItemEntity -> {
            LineItem lineItem = lineItemEntityToDTOTranslator.translate(lineItemEntity);
            lineItems.add(lineItem);
        });

        return Cart.builder()
                .customerId(input.getCustomerId())
                .lineItems(lineItems)
                .total(input.getTotal())
                .build();
    }
}
