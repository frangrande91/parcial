package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.model.Currency;
import com.parcialLabV.parcial.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    public void addCurrency(Currency currency) {
        currencyRepository.save(currency);
    }

    public List<Currency> getCurrencies() {
      return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer id) {
        return currencyRepository.findById(id).orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    public void deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
    }
}
