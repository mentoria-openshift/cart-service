package es.thalesalv.sigla.cartservicepricing.application.service;

import es.thalesalv.sigla.cartservicepricing.domain.model.Cart;

public interface PricingService {

    Cart price(Cart cart);
}
