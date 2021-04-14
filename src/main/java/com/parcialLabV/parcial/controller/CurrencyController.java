package com.parcialLabV.parcial.controller;

import com.parcialLabV.parcial.model.Currency;
import com.parcialLabV.parcial.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/")
    public void addCurrency(@RequestBody Currency currency){
        currencyService.addCurrency(currency);
    }

    @GetMapping
    public List<Currency> getCurrencies(){
        return currencyService.getCurrencies();
    }

    @GetMapping("/{id}")
    public Currency getCurrencyById(@PathVariable Integer id){
        return currencyService.getCurrencyById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCurrency(@PathVariable Integer id){
        currencyService.deleteCurrency(id);
    }
}
