package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    @DisplayName("Test for converter DTO to Entity")
    public void testConvertDTOToEntity_Success()
    {
        PropertyDTO propertyDTO = new PropertyDTO();

        propertyDTO.setTitle("Dummy Title");
        propertyDTO.setPrice(5656.5);

       PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(propertyDTO);

        Assertions.assertEquals(propertyDTO.getPrice() , propertyEntity.getPrice());
        Assertions.assertEquals(propertyDTO.getTitle() , propertyEntity.getTitle());
    }

    @Test
    @DisplayName("Test for converter Entity to DTO")
    public void testConvertEntityToDTO_Success()
    {
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setTitle("Dummy Title");
        propertyEntity.setPrice(6565.7);

        PropertyDTO propertyDTO = propertyConverter.convertEntityToDTO(propertyEntity);

        Assertions.assertEquals(propertyEntity.getPrice() , propertyDTO.getPrice());
        Assertions.assertEquals(propertyEntity.getTitle() , propertyDTO.getTitle());
    }
}
