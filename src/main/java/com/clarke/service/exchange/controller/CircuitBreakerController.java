package com.clarke.service.exchange.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreakerController {
    
    private final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
    
    @GetMapping("/api")
    @Retry(name="sample-api")  //fallbackMethod="goFallBack"
    @Bulkhead(name="default")
//    @RateLimiter(name="default")
    public String getApi(){
        log.debug("Sample API call that fails");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity(
//                        "http://localhost:8080/big-dummy", 
//                String.class);
//        return forEntity.getBody();
        return "sample-api";
    }
    
    public String goFallBack(Exception ex){
        return "The Fall Method";
    }
}
