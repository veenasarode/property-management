package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertDTOtoEntity(PropertyDTO propertyDTO)
    {
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setTitle(propertyDTO.getTitle());
        propertyEntity.setAddress(propertyDTO.getAddress());
        propertyEntity.setDescription(propertyDTO.getDescription());
        propertyEntity.setOwnerName(propertyDTO.getOwnerName());
        propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
        propertyEntity.setPrice(propertyDTO.getPrice());
        propertyEntity.setId(propertyDTO.getId());

        return propertyEntity;
    }

    public PropertyDTO convertEntityToDTO(PropertyEntity propertyEntity)
    {
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(propertyEntity.getId());
        propertyDTO.setTitle(propertyEntity.getTitle());
        propertyDTO.setAddress(propertyEntity.getAddress());
        propertyDTO.setDescription(propertyEntity.getDescription());
        propertyDTO.setOwnerName(propertyEntity.getOwnerName());
        propertyDTO.setOwnerEmail(propertyEntity.getOwnerEmail());
        propertyDTO.setPrice(propertyEntity.getPrice());

        return propertyDTO;
    }
}
