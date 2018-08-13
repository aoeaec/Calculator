package com.gaurav.calculator.service;

import java.util.List;
import org.springframework.stereotype.Component;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.CalculatorResponse;
import com.gaurav.calculator.model.integration.MathematicalOperator;

@Component
public interface CalculatorService {

    CalculatorResponse calculate(String operator,
                                 Double... values
                                 ) throws InvalidEntryException, InsufficientElementsException;

    List<MathematicalOperator> getOperations();
}
