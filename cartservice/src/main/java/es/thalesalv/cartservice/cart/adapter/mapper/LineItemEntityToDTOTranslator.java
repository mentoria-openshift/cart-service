package es.thalesalv.cartservice.cart.adapter.mapper;

import org.springframework.stereotype.Component;

import es.thalesalv.cartservice.cart.adapter.entity.LineItemEntity;
import es.thalesalv.cartservice.cart.domain.model.LineItem;

@Component
public class LineItemEntityToDTOTranslator implements Translator<LineItem, LineItemEntity> {

    @Override
    public LineItem translate(LineItemEntity input) {

        return LineItem.builder()
                .id(input.getId())
                .price(input.getPrice())
                .productName(input.getProductName())
                .quantity(input.getQuantity())
                .build();
    }
}
