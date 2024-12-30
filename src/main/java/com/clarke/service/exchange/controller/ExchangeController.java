package com.clarke.service.exchange.controller;

import com.clarke.service.exchange.beans.Exchange;
import com.clarke.service.exchange.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {
    
    @Autowired
    private Environment env;
    
    @Autowired
    private CurrencyExchangeRepository repo;

    private final Logger log = LoggerFactory.getLogger(ExchangeController.class);
                
    @GetMapping("/currency-exchange/from/{startCurrency}/to/{endCurrency}")
    public Exchange getConversionInfo(
                        @PathVariable String startCurrency, 
                        @PathVariable String endCurrency){
        
        log.info("GET /currency-exchange from {} to {}", startCurrency, endCurrency);
        Exchange currencyConversion = 
                repo.findByFromCurrencyAndToCurrency(startCurrency, endCurrency);  
        
        String port = env.getProperty("local.server.port");
        currencyConversion.setEnvironment(port);
        return currencyConversion;  
    }
}
