package com.lrp.currency_conversion_service.proxy;

import com.lrp.currency_conversion_service.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {

    @GetMapping("/v1/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    CurrencyConversion calculateExchangeRate(
            @PathVariable("fromCurrency") String fromCurrency,
            @PathVariable("toCurrency") String toCurrency);
}
