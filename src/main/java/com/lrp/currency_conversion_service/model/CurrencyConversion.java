package com.lrp.currency_conversion_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CurrencyConversion {

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionRate;
    private BigDecimal qty;
    private BigDecimal totalCalculatedAmount;
    private String environment;
}
