package es.thalesalv.cartservice.cart.adapter.entity;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.thalesalv.cartservice.cart.application.bean.MonetaryAmountConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount price;

    private String productName;
    private Integer quantity;
}
