package com.clarke.service.exchange.repository;

import com.clarke.service.exchange.beans.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<Exchange, Integer> {
    Exchange findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
