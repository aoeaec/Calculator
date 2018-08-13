package com.gaurav.calculator.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.CalculatorResponse;
import com.gaurav.calculator.model.integration.MathematicalOperator;
import com.gaurav.calculator.validator.OperatorValidator;


@Component
public class CalculatorServiceImpl implements CalculatorService {

    @Autowired
    OperatorValidator validator;

    public CalculatorResponse calculate(String operator,
                                        Double... values) throws InvalidEntryException, InsufficientElementsException {
        validator.validate(operator, values);
        return new CalculatorResponse(MathematicalOperator.parseOperator(operator).apply(values));
    }

    public List<MathematicalOperator> getOperations() {
        return Arrays.asList(MathematicalOperator.values());
    }
}
