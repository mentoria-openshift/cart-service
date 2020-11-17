package es.thalesalv.cartservice.pricing.application.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.springframework.stereotype.Service;

import es.thalesalv.cartservice.pricing.domain.model.Cart;
import es.thalesalv.cartservice.pricing.domain.model.LineItem;

@Service
public class PricingServiceImpl implements PricingService {

    private final CurrencyUnit brl = Monetary.getCurrency("BRL");

    @Override
    public Cart price(Cart cart) {
        MonetaryAmount total = Monetary.getDefaultAmountFactory()
                .setCurrency(brl)
                .setNumber(0)
                .create();

        for (LineItem li : cart.getLineItems()) {
            BigDecimal bigDecimal = BigDecimal.valueOf(Math.random() * 100)
                    .setScale(2, RoundingMode.HALF_UP);

            MonetaryAmount amount = Monetary.getDefaultAmountFactory()
                    .setCurrency(brl)
                    .setNumber(bigDecimal)
                    .create();

            li.setPrice(amount);
            total = total.add(amount.multiply(li.getQuantity()));
        }

        cart.setTotal(total);
        return cart;
    }
}
