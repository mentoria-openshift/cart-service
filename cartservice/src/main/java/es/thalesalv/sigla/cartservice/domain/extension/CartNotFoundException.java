package es.thalesalv.sigla.cartservice.domain.extension;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1308320049246401064L;

    public CartNotFoundException(Exception e) {
        super(e);
    }

    public CartNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
