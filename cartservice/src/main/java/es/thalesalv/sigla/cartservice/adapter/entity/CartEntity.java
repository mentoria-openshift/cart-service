package es.thalesalv.sigla.cartservice.adapter.entity;

import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import es.thalesalv.sigla.cartservice.application.bean.MonetaryAmountConverter;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount total;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LineItemEntity> lineItems = new ArrayList<>();

    private String customerId;

    public void addLineItem(LineItemEntity lineItem) {
        this.lineItems.add(lineItem);
    }
}
