package es.thalesalv.cartservice.cart.domain.model;

import javax.money.MonetaryAmount;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(exclude = "price")
public class LineItem {

    private Integer id;
    private MonetaryAmount price;
    private String productName;
    private Integer quantity;
}
