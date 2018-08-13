package com.gaurav.calculator.model.integration;

import static org.junit.Assert.*;

import org.junit.Test;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;

public class MathematicalOperatorTest {


    @Test
    public void getOperation() {
        assertEquals("add", MathematicalOperator.ADD.getOperation());
        assertEquals("subtract", MathematicalOperator.SUBTRACT.getOperation());
        assertEquals("multiply", MathematicalOperator.MULTIPLY.getOperation());
        assertEquals("divide", MathematicalOperator.DIVIDE.getOperation());
        assertEquals("power", MathematicalOperator.POWER.getOperation());
        assertEquals("ln", MathematicalOperator.LN.getOperation());
        assertEquals("log10", MathematicalOperator.LOG10.getOperation());
        assertEquals("square_root", MathematicalOperator.SQUARE_ROOT.getOperation());
        assertEquals("pi", MathematicalOperator.PI.getOperation());
        assertEquals("e", MathematicalOperator.E.getOperation());
    }


    @Test
    public void getArguments() {
        assertEquals(2, MathematicalOperator.ADD.getArguments());
        assertEquals(2, MathematicalOperator.SUBTRACT.getArguments());
        assertEquals(2, MathematicalOperator.MULTIPLY.getArguments());
        assertEquals(2, MathematicalOperator.DIVIDE.getArguments());
        assertEquals(2, MathematicalOperator.POWER.getArguments());
        assertEquals(1, MathematicalOperator.LN.getArguments());
        assertEquals(1, MathematicalOperator.LOG10.getArguments());
        assertEquals(1, MathematicalOperator.SQUARE_ROOT.getArguments());
        assertEquals(0, MathematicalOperator.PI.getArguments());
        assertEquals(0, MathematicalOperator.E.getArguments());

    }

    @Test
    public void getSymbol() {
        assertEquals("+", MathematicalOperator.ADD.getSymbol());
        assertEquals("-", MathematicalOperator.SUBTRACT.getSymbol());
        assertEquals("*", MathematicalOperator.MULTIPLY.getSymbol());
        assertEquals("/", MathematicalOperator.DIVIDE.getSymbol());
        assertEquals("^", MathematicalOperator.POWER.getSymbol());
        assertEquals("ln", MathematicalOperator.LN.getSymbol());
        assertEquals("log", MathematicalOperator.LOG10.getSymbol());
        assertEquals("\u221A", MathematicalOperator.SQUARE_ROOT.getSymbol());
        assertEquals("\u03C0", MathematicalOperator.PI.getSymbol());
        assertEquals("e", MathematicalOperator.E.getSymbol());
    }

    @Test
    public void getDescription() {
        assertEquals("Add", MathematicalOperator.ADD.getDescription());
        assertEquals("Subtract", MathematicalOperator.SUBTRACT.getDescription());
        assertEquals("Multiply", MathematicalOperator.MULTIPLY.getDescription());
        assertEquals("Divide", MathematicalOperator.DIVIDE.getDescription());
        assertEquals("Power Of", MathematicalOperator.POWER.getDescription());
        assertEquals("Log, Natural", MathematicalOperator.LN.getDescription());
        assertEquals("Log, Base 10", MathematicalOperator.LOG10.getDescription());
        assertEquals("Square Root", MathematicalOperator.SQUARE_ROOT.getDescription());
        assertEquals("\u03C0", MathematicalOperator.PI.getDescription());
        assertEquals("e", MathematicalOperator.E.getDescription());

    }

    @Test
    public void parseOperator() throws InvalidEntryException {
        assertEquals(MathematicalOperator.ADD, MathematicalOperator.parseOperator("add"));
        assertEquals(MathematicalOperator.SUBTRACT, MathematicalOperator.parseOperator("subtract"));
        assertEquals(MathematicalOperator.MULTIPLY, MathematicalOperator.parseOperator("multiply"));
        assertEquals(MathematicalOperator.DIVIDE, MathematicalOperator.parseOperator("divide"));
        assertEquals(MathematicalOperator.POWER, MathematicalOperator.parseOperator("power"));
        assertEquals(MathematicalOperator.LOG10, MathematicalOperator.parseOperator("log10"));
        assertEquals(MathematicalOperator.LN, MathematicalOperator.parseOperator("ln"));
        assertEquals(MathematicalOperator.SQUARE_ROOT, MathematicalOperator.parseOperator("square_root"));
        assertEquals(MathematicalOperator.E, MathematicalOperator.parseOperator("e"));
        assertEquals(MathematicalOperator.PI, MathematicalOperator.parseOperator("pi"));
    }

    @Test(expected = InvalidEntryException.class)
    public void parseOperatorInvalid() throws InvalidEntryException {
        MathematicalOperator.parseOperator("RANDOM");
    }

    @Test(expected = InvalidEntryException.class)
    public void parseOperatorBlank() throws InvalidEntryException {
        MathematicalOperator.parseOperator("");
    }
}