package es.thalesalv.cartservice.pricing.application.service;

import es.thalesalv.cartservice.pricing.domain.model.Cart;

public interface PricingService {

    Cart price(Cart cart);
}
