package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.Component;
import com.kbe.shoppingapp.repository.ComponentRepository;
import com.kbe.shoppingapp.repository.ComponentTypeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentService implements IComponentService {

	@Autowired
	private final ComponentRepository componentRepository;
	@Autowired
	private final ComponentTypeRepository componentTypeRepository;

	public ComponentService(ComponentRepository componentRepository, ComponentTypeRepository componentTypeRepository) {
		this.componentRepository = componentRepository;
		this.componentTypeRepository = componentTypeRepository;
		this.componentRepository.deleteAll();
	}

	// Save operation
	@Override
	public Component create(Component Component)
	{
		return this.componentRepository.save(Component);
	}

	// Read operation
	@Override 
	public List<Component> readAll()
	{
		return (List<Component>) this.componentRepository.findAll();
	}

	// Read operation
	@Override 
	public Component readById(Long componentId)
	{
		return this.componentRepository.findById(componentId).get();
	}

	// Update operation
	@Override
	public Component update(Component component, Long componentId) {
		Component _component = this.componentRepository.findById(componentId).get();

		_component.setName(component.getName());
		_component.setUsdPrice(component.getUsdPrice());
		_component.setComponentIds(component.getComponentIds());
				
		return this.componentRepository.save(_component);
	}

	// Delete operation
	@Override
	public void deleteById(Long ComponentId)
	{
		this.componentRepository.deleteById(ComponentId);
	}

	@Override
	public void deleteAll()
	{
		this.componentRepository.deleteAll();
	}
}