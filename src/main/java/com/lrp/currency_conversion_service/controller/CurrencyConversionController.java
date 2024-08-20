package com.lrp.currency_conversion_service.controller;

import com.lrp.currency_conversion_service.model.CurrencyConversion;
import com.lrp.currency_conversion_service.proxy.CurrencyExchangeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {
    private final CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{qty}")
    public CurrencyConversion calculateExchangeRate(
        @PathVariable String fromCurrency,
        @PathVariable String toCurrency,
        @PathVariable BigDecimal qty) {

        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
          "http://localhost:8000/v1/currency-exchange/from/{fromCurrency}/to/{toCurrency}",
                CurrencyConversion.class, uriVariables
        );

        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(
                currencyConversion.getId(),
                fromCurrency,
                toCurrency,
                currencyConversion.getConversionRate(),
                qty,
                qty.multiply(currencyConversion.getConversionRate()),
                currencyConversion.getEnvironment() + " - Rest Template"
        );
    }

    @GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{qty}")
    public CurrencyConversion calculateExchangeRateUsingFeign(
            @PathVariable String fromCurrency,
            @PathVariable String toCurrency,
            @PathVariable BigDecimal qty) {

        CurrencyConversion currencyConversion =
                currencyExchangeProxy.calculateExchangeRate(fromCurrency,toCurrency);

        return new CurrencyConversion(
                currencyConversion.getId(),
                fromCurrency,
                toCurrency,
                currencyConversion.getConversionRate(),
                qty,
                qty.multiply(currencyConversion.getConversionRate()),
                currencyConversion.getEnvironment() + " - Feign"
        );

    }

}
