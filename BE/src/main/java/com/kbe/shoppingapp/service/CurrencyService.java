package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.repository.CurrencyRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {

	@Autowired
	private final CurrencyRepository currencyRepository;

	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
		this.currencyRepository.deleteAll();
	}

	// Save operation
	@Override
	public Currency create(Currency Currency)
	{
		return this.currencyRepository.save(Currency);
	}

	// Read operation
	@Override 
	public List<Currency> readAll()
	{
		return (List<Currency>) this.currencyRepository.findAll();
	}

	// Update operation
	@Override
	public Currency update(Currency currency, Long currencyId) {
		Currency _currency = this.currencyRepository.findById(currencyId).get();

		_currency.setName(currency.getName());
		_currency.setUsdConversionRate(currency.getUsdConversionRate());
				
		return this.currencyRepository.save(_currency);
	}

	// Delete operation
	@Override
	public void deleteByIsoCode(String isoCode)
	{
		this.currencyRepository.deleteByIsoCode(isoCode);
	}

	@Override
	public void deleteAll()
	{
		this.currencyRepository.deleteAll();
	}

	@Override
	public Currency readByIsoCode(String isoCode) {
		return (Currency) this.currencyRepository.findByIsoCode(isoCode);
	}
}