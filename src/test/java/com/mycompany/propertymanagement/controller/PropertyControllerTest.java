package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @InjectMocks
    private PropertyController propertyController;//mockito is going to create proxy object and inject it to our test

    @Mock//mockito will give memory to propertyservice and inject this dummy object into dummy object of propertycontroller
    private PropertyService propertyService;

    @Test
    @DisplayName("Test Success scenario for saving new property")
    public void testSaveProperty()
    {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setTitle("Dummy Property");

        PropertyDTO saveProperty = new PropertyDTO();
        saveProperty.setId(1L);
        saveProperty.setTitle(propertyDTO.getTitle());

        Mockito.when(propertyService.saveProperty(propertyDTO)).thenReturn(saveProperty);

        ResponseEntity<PropertyDTO> responseEntity = propertyController.saveProperty(propertyDTO);

        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value() ,  responseEntity.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test Success scenario for Fetching all properties")
    public void testGetProperty()
    {
        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setId(1L);
        propertyDTO.setTitle("Dummy Property");

        propertyDTOList.add(propertyDTO);

        Mockito.when(propertyService.getAllProperties()).thenReturn(propertyDTOList);

        ResponseEntity<List<PropertyDTO>> responseEntity = propertyController.getAllProperties();

        Assertions.assertEquals(1, responseEntity.getBody().size());
        Assertions.assertEquals(HttpStatus.OK.value() , responseEntity.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test Success scenario for updating only price of property")
    public void testUpdatePropertyPrice()
    {
        PropertyDTO propertyDTO = new PropertyDTO();
        propertyDTO.setPrice(3536.56);

        Mockito.when(propertyService.updatePropertyPrice(Mockito.any() , Mockito.anyLong())).thenReturn(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = propertyController.updatePropertyPrice(propertyDTO , 1L);

        Assertions.assertEquals(3536.56 , responseEntity.getBody().getPrice());
        Assertions.assertEquals(HttpStatus.OK.value() , responseEntity.getStatusCodeValue());
    }
}
