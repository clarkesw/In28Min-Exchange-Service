package com.clarke.service.exchange.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Exchange {
    
    @Id
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private String environment;

    public Exchange() {}

    public Exchange(int id, String fromCurrency, String toCurrency, BigDecimal conversionMultiple, String environment) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyConversion{" + "id=" + id + ", from=" + fromCurrency + ", to=" + toCurrency + ", conversionMultiple=" + conversionMultiple + ", environment=" + environment + '}';
    }  
}
