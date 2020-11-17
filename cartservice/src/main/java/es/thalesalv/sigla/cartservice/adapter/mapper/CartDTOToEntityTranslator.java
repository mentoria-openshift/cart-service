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
public class CartDTOToEntityTranslator implements Translator<CartEntity, Cart> {

    private final Translator<LineItemEntity, LineItem> lineItemDTOToEntityTranslator;

    @Override
    public CartEntity translate(Cart input) {

        List<LineItemEntity> lineItems = new ArrayList<>();
        input.getLineItems().forEach(lineItem -> {
            LineItemEntity lineItemEntity = lineItemDTOToEntityTranslator.translate(lineItem);
            lineItems.add(lineItemEntity);
        });

        return CartEntity.builder()
                .id(input.getId())
                .customerId(input.getCustomerId())
                .lineItems(lineItems)
                .total(input.getTotal())
                .build();
    }
}
