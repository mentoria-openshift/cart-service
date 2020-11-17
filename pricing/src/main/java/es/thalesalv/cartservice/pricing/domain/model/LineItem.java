package es.thalesalv.cartservice.pricing.domain.model;

import javax.money.MonetaryAmount;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LineItem {

    private Integer id;
    private Integer quantity;
    private MonetaryAmount price;
    private String productName;

    public LineItem(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
