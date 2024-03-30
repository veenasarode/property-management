package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    //Restful api is just mapping  of url to a java class function
    @GetMapping("/hello")
    public String sayHello()
    {
        return "Hello";
    }

    @PostMapping("/save")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
       propertyDTO = propertyService.saveProperty(propertyDTO);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO , HttpStatus.CREATED);

        return responseEntity;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> propertyList = propertyService.getAllProperties();

        ResponseEntity<List<PropertyDTO>> responseEntity = new ResponseEntity<>(propertyList , HttpStatus.OK);

        return responseEntity;
    }

    @PutMapping("/update/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperties(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId)
    {
      PropertyDTO updateOne = propertyService.updateProperty(propertyDTO , propertyId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO , HttpStatus.OK);

        return responseEntity;
    }

    @PatchMapping("/update_description/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId){

        PropertyDTO updateOne = propertyService.updatePropertyDescription(propertyDTO , propertyId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO , HttpStatus.OK);

        return responseEntity;
    }

    @PatchMapping("/update_price/{propertyId}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO , @PathVariable Long propertyId){
        PropertyDTO updateOne = propertyService.updatePropertyPrice(propertyDTO , propertyId);

        ResponseEntity<PropertyDTO> responseEntity = new ResponseEntity<>(propertyDTO , HttpStatus.OK);

        return responseEntity;
    }

    @DeleteMapping("delete/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId)
    {
        propertyService.deleteProperty(propertyId);

        ResponseEntity<Void> responseEntity = new ResponseEntity<>(null , HttpStatus.NO_CONTENT);

        return responseEntity;
    }
}
