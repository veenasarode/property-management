package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.exception.BuisenessException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);

    public List<PropertyDTO> getAllProperties();

    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyDescription(@RequestBody PropertyDTO propertyDTO , Long propertyId) throws BuisenessException;

    PropertyDTO updatePropertyPrice(@RequestBody PropertyDTO propertyDTO , Long propertyId);

    void deleteProperty(Long propertyId);
}
