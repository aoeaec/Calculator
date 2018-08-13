package com.gaurav.calculator.web.controller;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.gaurav.calculator.config.TestConfiguration;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.CalculatorResponse;
import com.gaurav.calculator.model.integration.MathematicalOperator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration.class})
public class CalculatorControllerTest {

    @Autowired
    private CalculatorController calculatorController;

    @Test
    public void operate() throws InsufficientElementsException, InvalidEntryException {
        Assert.assertNotNull(calculatorController);
        CalculatorResponse add = calculatorController.operate("add", 1.0, 2.0);
        Assert.assertEquals(3.0, add.getResult(),0);

        CalculatorResponse multiply = calculatorController.operate("multiply", -3d, 50d);
        assertEquals(-150.0, multiply.getResult(), 0);

    }

    @Test
    public void getOperations() {

        List<MathematicalOperator> operations = calculatorController.getOperations();
        assertEquals(10, operations.size());
        assertEquals(MathematicalOperator.ADD, operations.get(0));
        assertEquals(MathematicalOperator.SUBTRACT, operations.get(1));
        assertEquals(MathematicalOperator.POWER, operations.get(2));
        assertEquals(MathematicalOperator.MULTIPLY, operations.get(3));
        assertEquals(MathematicalOperator.DIVIDE, operations.get(4));
        assertEquals(MathematicalOperator.SQUARE_ROOT, operations.get(5));
        assertEquals(MathematicalOperator.LOG10, operations.get(6));
        assertEquals(MathematicalOperator.LN, operations.get(7));
        assertEquals(MathematicalOperator.PI, operations.get(8));
        assertEquals(MathematicalOperator.E, operations.get(9));
    }
}