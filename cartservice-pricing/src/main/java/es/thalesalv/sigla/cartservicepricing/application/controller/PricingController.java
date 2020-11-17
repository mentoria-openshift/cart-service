package es.thalesalv.sigla.cartservicepricing.application.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.thalesalv.sigla.cartservicepricing.application.service.PricingService;
import es.thalesalv.sigla.cartservicepricing.domain.model.Cart;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PricingController {

    private final PricingService pricingService;

    @PostMapping("/pricing/price")
    public Cart price(@RequestBody Cart cart) {

        return pricingService.price(cart);
    }
}
