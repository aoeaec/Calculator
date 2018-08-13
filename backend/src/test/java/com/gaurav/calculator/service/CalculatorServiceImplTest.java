package com.gaurav.calculator.service;

import static org.junit.Assert.assertEquals;

import java.util.List;
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
public class CalculatorServiceImplTest {

    @Autowired
    CalculatorService calculatorService;


    private CalculatorResponse calculatorResponse;


    @Test
    public void calculatePositiveScenarioAdd() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("add", 2d, 4d);
        assertEquals(6.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("add", 2.67, -4d);
        assertEquals(-1.33, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("add", -98d, -2d);
        assertEquals(-100.0, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioMultiply() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("multiply", 3d, 27d);
        assertEquals(81.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("multiply", -3d, 50d);
        assertEquals(-150.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("multiply", -3.9, -50.2);
        assertEquals(195.78, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioSubtract() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("subtract", 12d, 4d);
        assertEquals(8.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("subtract", -3d, 50d);
        assertEquals(-53.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("subtract", -3.9, -50.5);
        assertEquals(46.6, calculatorResponse.getResult(), Double.MIN_VALUE);
    }

    @Test
    public void calculatePositiveScenarioDivide() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("divide", 2d, 4d);
        assertEquals(0.5, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("divide", -3d, 34.0);
        assertEquals(-0.08823529411764706, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("divide", -300.9, -50.5);
        assertEquals(5.958415841584158, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioPower() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("power", 2d, 4d);
        assertEquals(16.0, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("power", -3d, 34.0);
        assertEquals(1.667718169966657E16, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("power", 25.0, -2.0);
        assertEquals(0.0016, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("power", 25.0, .5);
        assertEquals(5, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioSquareRoot() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("square_root", 5.0);
        assertEquals(2.23606797749979, calculatorResponse.getResult(), 0);

        calculatorResponse = calculatorService.calculate("square_root", 64.0);
        assertEquals(8.0, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioLog10() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("log10", 10.0);
        assertEquals(1, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioLogN() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("ln", 35.0);
        assertEquals(3.5553480614894135, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioPI() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("pi");
        assertEquals(3.141592653589793, calculatorResponse.getResult(), 0);
    }

    @Test
    public void calculatePositiveScenarioE() throws InsufficientElementsException, InvalidEntryException {
        calculatorResponse = calculatorService.calculate("e");
        assertEquals(2.718281828459045, calculatorResponse.getResult(), 0);
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioAdd() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("add", -98d);
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioMultiply() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("multiply", -3.9);
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioSubtract() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("subtract", -3.9);
    }

    @Test(expected = InvalidEntryException.class)
    public void calculateNegativeScenarioDivideInvalidEntry() throws InsufficientElementsException, InvalidEntryException {
        //calculatorService.calculate("divide", 2d, 0.0);

        calculatorService.calculate("divide", 0d, 0d);

    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioDivideInsufficientElemts() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("divide", 2d);
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioPowerInSufficientElements() throws InsufficientElementsException, InvalidEntryException {

        calculatorService.calculate("power", 2d);

    }

    @Test(expected = InvalidEntryException.class)
    public void calculateNegativeScenarioSquareRoot() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("square_root", -64.0);
    }

    @Test(expected = InvalidEntryException.class)
    public void calculateNegativeScenarioLog10() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("log10", -10.0);
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioSquareRootNoArguments() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("square_root");
    }

    @Test(expected = InsufficientElementsException.class)
    public void calculateNegativeScenarioLog10NoArguments() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("log10");
    }

    @Test(expected = InvalidEntryException.class)
    public void calculateNegativeScenarioLogN() throws InsufficientElementsException, InvalidEntryException {
        calculatorService.calculate("ln", -35.0);
    }


    @Test
    public void getOperations() {
        List<MathematicalOperator> operations = calculatorService.getOperations();
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
        System.out.println("");
    }
}