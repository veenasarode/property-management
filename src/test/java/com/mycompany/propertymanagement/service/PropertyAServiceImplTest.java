package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.exception.BuisenessException;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyAServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyConverter propertyConverter;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
    public void testSaveProperty_Success()
    {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle("Dummy");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");
        Mockito.when(propertyConverter.convertDTOtoEntity(Mockito.any())).thenReturn(propertyEntity);

        PropertyEntity savedEntity = new PropertyEntity();
        savedEntity.setTitle("Dummy");
        savedEntity.setId(1L);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);

        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setTitle("Dummy");
        savedDto.setId(1L);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);

        PropertyDTO result = propertyServiceImpl.saveProperty(propertyDTO);

        Assertions.assertEquals(savedDto.getId() , result.getId());
    }

    @Test
    public void testGetAllProperties_Success()
    {
        List<PropertyEntity> propertyEntityList = new ArrayList<>();

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("Dummy");

        propertyEntityList.add(propertyEntity);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntityList);

        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setTitle("Dummy");
        savedDto.setId(1L);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);

       List<PropertyDTO> propertyDTOList = propertyServiceImpl.getAllProperties();

        Assertions.assertEquals(1 , propertyDTOList.size());
    }

    @Test
    public void testUpdateProperty_Success()
    {
        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setTitle("Dummy");
        savedDto.setId(1L);
        savedDto.setPrice(25684.33);
        savedDto.setOwnerName("ABCD");
        savedDto.setAddress("xyz");
        savedDto.setDescription("lmn");
        savedDto.setOwnerEmail("abc@gmail.com");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");
        propertyEntity.setId(1L);
        propertyEntity.setPrice(25684.33);
        propertyEntity.setOwnerName("ABCD");
        propertyEntity.setAddress("xyz");
        propertyEntity.setDescription("lmn");
        propertyEntity.setOwnerEmail("abc@gmail.com");

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(propertyEntity));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);

       PropertyDTO updatedProperty = propertyServiceImpl.updateProperty(savedDto , 1L);

       Assertions.assertEquals(savedDto.getTitle() , updatedProperty.getTitle());
        Assertions.assertEquals(savedDto.getPrice() , updatedProperty.getPrice());
    }

    @Test
    public void testUpdatePropertyDispcription_Success()
    {
        PropertyDTO savedDto = new PropertyDTO();
        savedDto.setTitle("Dummy");
        savedDto.setId(1L);
        savedDto.setPrice(25684.33);
        savedDto.setOwnerName("ABCD");
        savedDto.setAddress("xyz");
        savedDto.setDescription("lmn");
        savedDto.setOwnerEmail("abc@gmail.com");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");
        propertyEntity.setId(1L);
        propertyEntity.setPrice(25684.33);
        propertyEntity.setOwnerName("ABCD");
        propertyEntity.setAddress("xyz");
        propertyEntity.setDescription("lmn");
        propertyEntity.setOwnerEmail("abc@gmail.com");

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(propertyEntity));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDto);

        PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDto , 1L);

        Assertions.assertEquals(savedDto.getDescription() , updatedProperty.getDescription());

    }

    @Test
    public void testUpdatePropertyDispcription_Failure()
    {
        PropertyDTO savedDto = new PropertyDTO();

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        BuisenessException exception = Assertions.assertThrows(BuisenessException.class , ()-> {
            PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDto , 1L);
        });

        Assertions.assertEquals("No Property Found for update" , exception.getMessage());

    }


}
