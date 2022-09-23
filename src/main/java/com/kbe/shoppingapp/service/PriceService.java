
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Component;
import com.kbe.shoppingapp.model.Currency;
import com.kbe.shoppingapp.model.Price;
import com.kbe.shoppingapp.repository.ComponentRepository;
import com.kbe.shoppingapp.repository.CurrencyRepository;
import com.kbe.shoppingapp.repository.PriceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService implements IPriceService {

	@Autowired
	private final ComponentRepository componentRepository;
	private final PriceRepository priceRepository;
	private final CurrencyRepository currencyRepository;

	public PriceService(PriceRepository priceRepository, ComponentRepository componentRepository, CurrencyRepository currencyRepository) {
		this.priceRepository = priceRepository;
		this.componentRepository = componentRepository;
		this.currencyRepository = currencyRepository;
		this.priceRepository.deleteAll();
	}

	private Float calculateTotalUsdPrice(Long componentId) {
		try {
			Component component = this.componentRepository.findById(componentId).get();
			Float total = 0.f;
			if (component.getUsdPrice() == null) {
				for (Long childId : component.getComponentIds()) {
					total += calculateTotalUsdPrice(childId);
				}
				return total;
			} else {
				return component.getUsdPrice();
			}
		} catch (Exception e) {
			return 0.f;
		}
	}

	@Override
	public Price calculatePriceForComponent(long componentId, String currencyIso) {
		Currency currency = this.currencyRepository.findByIsoCode(currencyIso);
		Float totalPrice = calculateTotalUsdPrice(componentId) * currency.getUsdConversionRate();
		return new Price(totalPrice, currency.getIsoCode(), componentId);
	}

	
	/* 
	CRUD operation are propably not needed for the price endpoint. Prices are 
	calculated on demand and not stored on the DB.

	// Save operation
	@Override
	public Price create(Price Price)
	{
		return this.priceRepository.save(Price);
	}

	// Read operation
	@Override 
	public List<Price> readAll()
	{
		return (List<Price>) this.priceRepository.findAll();
	}

	// Read operation
	@Override 
	public Price readById(Long componentId)
	{
		return this.priceRepository.findById(componentId).get();
	}
	
	// Update operation
	@Override
	public Price update(Price component, Long componentId) {
		Price _component = this.priceRepository.findById(componentId).get();

		//_component.setName(component.getName());
				
		return this.priceRepository.save(_component);
	}

	// Delete operation
	@Override
	public void deleteById(Long PriceId)
	{
		this.priceRepository.deleteById(PriceId);
	}

	@Override
	public void deleteAll()
	{
		this.priceRepository.deleteAll();
	}
	*/


}