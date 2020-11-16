package es.thalesalv.sigla.cartservice.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Cart {

    private Integer id;
    private MonetaryAmount total;
    private List<LineItem> lineItems = new ArrayList<>();
    private String customerId;

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
}
