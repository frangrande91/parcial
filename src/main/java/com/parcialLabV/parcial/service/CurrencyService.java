package com.parcialLabV.parcial.service;

import com.parcialLabV.parcial.model.Currency;
import com.parcialLabV.parcial.model.PostResponse;
import com.parcialLabV.parcial.repository.CurrencyRepository;
import com.parcialLabV.parcial.utils.EntityURLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class CurrencyService {

    private static final String CURRENCY_PATH = "currencies" ;
    @Autowired
    private CurrencyRepository currencyRepository;


    public PostResponse addCurrency(Currency currency) {
        Currency newCurrency = currencyRepository.save(currency);
        return PostResponse.builder().httpStatus(HttpStatus.CREATED).url(EntityURLBuilder.buildURL(CURRENCY_PATH, currency.getId())).build();
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
