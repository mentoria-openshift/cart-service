package es.thalesalv.sigla.cartservice.adapter.mapper;

public interface Translator<R, S> {
    
    public R translate(S input);
}
