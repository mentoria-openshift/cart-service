package es.thalesalv.cartservice.pricing.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {

    private Integer id;
    private String customerId;
    private List<LineItem> lineItems = new ArrayList<>();
    private MonetaryAmount total;

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);
    }
}