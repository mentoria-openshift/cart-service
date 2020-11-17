package es.thalesalv.sigla.cartservice.domain.extension;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class PricingException extends RuntimeException {

    private static final long serialVersionUID = -4082267001690098985L;

    public PricingException(Exception e) {
        super(e);
    }

    public PricingException(String message, Throwable t) {
        super(message, t);
    }

    public PricingException(String message) {
        super(message);
    }
}
