package es.thalesalv.cartservice.pricing.adapter.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zalando.jackson.datatype.money.MoneyModule;

@Configuration
public class WebConfigBean implements WebMvcConfigurer {

    @Bean
    public MoneyModule moneyModule() {
        return new MoneyModule().withDefaultFormatting();
    }
}