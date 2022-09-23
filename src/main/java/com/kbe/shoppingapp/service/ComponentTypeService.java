
package com.kbe.shoppingapp.service;

import com.kbe.shoppingapp.model.ComponentType;
import com.kbe.shoppingapp.repository.ComponentTypeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponentTypeService
	implements IComponentTypeService {

	@Autowired
	private final ComponentTypeRepository componentTypeRepository;

	public ComponentTypeService(ComponentTypeRepository componentTypeRepository) {
		this.componentTypeRepository = componentTypeRepository;
		this.componentTypeRepository.deleteAll();
	}

	// Save operation
	@Override
	public ComponentType create(ComponentType ComponentType)
	{
		return this.componentTypeRepository.save(ComponentType);
	}

	// Read operation
	@Override 
	public List<ComponentType> readAll()
	{
		return (List<ComponentType>) this.componentTypeRepository.findAll();
	}

	// Read operation
	@Override 
	public ComponentType readById(Long componentTypeId)
	{
		return this.componentTypeRepository.findById(componentTypeId).get();
	}

	// Update operation
	@Override
	public ComponentType update(
		ComponentType componentType,
		Long componentTypeId
	) {
		ComponentType _componentType = this.componentTypeRepository.findById(componentTypeId).get();

		_componentType.setName(componentType.getName());
				
		return this.componentTypeRepository.save(_componentType);
	}

	// Delete operation
	@Override
	public void deleteById(Long ComponentTypeId)
	{
		this.componentTypeRepository.deleteById(ComponentTypeId);
	}

	@Override
	public void deleteAll()
	{
		this.componentTypeRepository.deleteAll();
	}
}
