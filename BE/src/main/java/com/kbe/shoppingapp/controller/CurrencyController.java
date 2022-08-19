package com.kbe.shoppingapp.controller;
import java.util.List;

import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.service.ICurrencyService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
class CurrencyController {

  @Autowired
  private ICurrencyService currencyService;

  @GetMapping("/currencies")
  public List<Currency> getCurrencys() {
    return (List<Currency>) this.currencyService.readAll();
  }

  @GetMapping("/currencies/{isoCode}")
  public Currency getCurrencyById(
    @PathVariable("isoCode") String isoCode) {
    return (Currency) this.currencyService.readByIsoCode(isoCode);
  }

  @PostMapping("/currencies")
  Currency insertCurrency(@RequestBody Currency currency) {
    //currency.setId(sequenceGeneratorService.generateSequence(Currency.SEQUENCE_NAME));
    return this.currencyService.create(currency);
  }

  @PutMapping("/currencies/{id}")
  public Currency updateCurrency(@PathVariable("id") long id, @RequestBody Currency currency) {
    return this.currencyService.update(currency, id);
  }

  @DeleteMapping("/currencies/{isoCode}")
  public String deleteCurrency(@PathVariable("isoCode") String isoCode) {
    this.currencyService.deleteByIsoCode(isoCode);

    return "deleted currency: " + isoCode;
  }

  @DeleteMapping("/currencies")
  public String deleteAllCurrencys() {
    this.currencyService.deleteAll();

    return "deleted all currencies";
  }
}