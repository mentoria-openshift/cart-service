package es.thalesalv.sigla.cartservice.application.bean;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;

public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {

    private final CurrencyUnit brl = Monetary.getCurrency("BRL");

    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        if (monetaryAmount == null) {
            return null;
        }

        return monetaryAmount.getNumber().numberValue(BigDecimal.class);
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }

        return Monetary.getDefaultAmountFactory()
                .setCurrency(brl)
                .setNumber(bigDecimal.doubleValue())
                .create();
    }
}
