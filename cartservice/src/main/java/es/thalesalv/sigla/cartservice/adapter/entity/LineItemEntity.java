package es.thalesalv.sigla.cartservice.adapter.entity;

import javax.money.MonetaryAmount;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import es.thalesalv.sigla.cartservice.application.bean.MonetaryAmountConverter;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class LineItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Convert(converter = MonetaryAmountConverter.class)
    private MonetaryAmount price;

    private String productName;
    private Integer quantity;
}