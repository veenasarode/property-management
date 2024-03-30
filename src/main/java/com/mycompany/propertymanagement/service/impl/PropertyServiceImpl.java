package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.exception.BuisenessException;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

       PropertyEntity propertyEntity =  propertyConverter.convertDTOtoEntity(propertyDTO);

        PropertyEntity saveProperty = propertyRepository.save(propertyEntity);

        PropertyDTO saveDto = propertyConverter.convertEntityToDTO(saveProperty);

        return saveDto;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        List<PropertyEntity> propertyEntityList = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propertyDTOList = new ArrayList<>();

        for (PropertyEntity pe : propertyEntityList){
            PropertyDTO propertyDto =  propertyConverter.convertEntityToDTO(pe);
            propertyDTOList.add(propertyDto);
        }
        return propertyDTOList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDTO UpdatedDto = null;

        if(optionalPropertyEntity.isPresent())
        {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();//data from database

            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwnerName(propertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(propertyDTO.getOwnerEmail());
            propertyEntity.setPrice(propertyDTO.getPrice());

            UpdatedDto = propertyConverter.convertEntityToDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return UpdatedDto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) throws BuisenessException {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDTO UpdatedDto = null;

        if(optionalPropertyEntity.isPresent())
        {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();//data from database

            propertyEntity.setDescription(propertyDTO.getDescription());

            UpdatedDto = propertyConverter.convertEntityToDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }else {
            throw new BuisenessException("No Property Found for update");
        }
        return UpdatedDto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);

        PropertyDTO UpdatedDto = null;

        if(optionalPropertyEntity.isPresent())
        {
            PropertyEntity propertyEntity = optionalPropertyEntity.get();//data from database

            propertyEntity.setPrice(propertyDTO.getPrice());

            UpdatedDto = propertyConverter.convertEntityToDTO(propertyEntity);

            propertyRepository.save(propertyEntity);
        }
        return UpdatedDto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
