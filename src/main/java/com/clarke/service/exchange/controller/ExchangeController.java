package com.clarke.service.exchange.controller;

import com.clarke.service.exchange.beans.CurrencyConversion;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    
    @Autowired
    private Environment env;

    @GetMapping("/currency-exchange/from/{startCurrency}/to/{endCurrency}")
    public CurrencyConversion getConversionInfo(
                @PathVariable String startCurrency, 
                @PathVariable String endCurrency){
        CurrencyConversion currencyConversion = new CurrencyConversion(1, startCurrency, endCurrency, 
                BigDecimal.valueOf(1), "8000 instance-id");  
        
        String port = env.getProperty("server.local.port");
        currencyConversion.setEnvironment(port);
        return currencyConversion;  
    }
}
