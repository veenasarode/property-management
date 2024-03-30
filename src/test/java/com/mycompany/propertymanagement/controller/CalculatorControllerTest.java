package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController calculatorController;

   static Double num1;
   static Double num2;
   static Double num3;

    @BeforeEach
    void init()
    {
        System.out.println("Before Each");
    }

    @BeforeAll
    static void beforeAll()
    {
        System.out.println("Before All");
        num1 = 3.5;
        num2 = 3.5;
        num3 = 3.5;
    }

    @AfterEach
    void destroy()
    {
        System.out.println("After Each");

    }

    @AfterAll
    static void afterAll()
    {
        System.out.println("After All");
        num1 = null;
        num2 = null;
        num3 = null;
    }

    @Test
    @DisplayName("Test Addition Success scenario")
    void testAddFunction_Success()
    {
        System.out.println("This is Test Success scenario");

      Double result = calculatorController.add(2.5,2.5);

        Assertions.assertEquals(5,result);
    }

    @Test
    //@Disabled
    @DisplayName("Test Addition Failure scenario")
    void testAddFunction_Failure()
    {
        System.out.println("This is Test Failure scenario");

        Double result = calculatorController.add(num1,num2);

        Assertions.assertNotEquals(5,result);
    }

    @Test
    @DisplayName("Test Subtraction for num1>num2 scenario")
    public void testSubtractFunction_num1_grt_num2()
    {
        Double result = calculatorController.subtract(num1+1 , num2);

        Assertions.assertEquals(1.0 , result);
    }

    @Test
    @DisplayName("Test Subtraction for num2>num1 scenario")
    public void testSubtractFunction_num2_grt_num1()
    {
        Double result = calculatorController.subtract(num1 , num2+1);

        Assertions.assertEquals(1.0 , result);
    }

    @Test
    @DisplayName("Test Multiplication")
    public void testMultiplication()
    {

        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorDTO.setNum3(num3);
        calculatorDTO.setNum4(2.0);

      ResponseEntity<Double> responseEntity = calculatorController.multiply(calculatorDTO);
      Assertions.assertEquals(85.75 , responseEntity.getBody());
      Assertions.assertEquals(HttpStatus.CREATED.value() ,responseEntity.getStatusCodeValue() , "Expecting Status as CREATED");
    }


}
