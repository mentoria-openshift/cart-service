package es.thalesalv.cartservice.cart.adapter.mapper;

public interface Translator<R, S> {
    
    public R translate(S input);
}
