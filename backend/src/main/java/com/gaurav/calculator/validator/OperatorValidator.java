package com.gaurav.calculator.validator;

import org.springframework.stereotype.Component;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.MathematicalOperator;

@Component
public class OperatorValidator {

    public boolean validate(String mathematicalOperator, Double... values) throws InsufficientElementsException, InvalidEntryException {
        return (validateOperator(mathematicalOperator)
            && validateArguments(MathematicalOperator.parseOperator(mathematicalOperator), values));
    }

    private boolean validateOperator(String operator) throws InvalidEntryException {
        for (MathematicalOperator op : MathematicalOperator.values()) {
            if (op.getOperation().equals(operator)) return true;
        }
        throw new InvalidEntryException("Illegal Operator value " + operator);
    }


    private boolean validateArguments(MathematicalOperator mathematicalOperator, Double... values) throws InsufficientElementsException {
        if (mathematicalOperator.getArguments() > values.length) {
            throw new InsufficientElementsException(values.length + " elements are provided for " + mathematicalOperator.getOperation() + " operation");
        }
        return true;
    }
}
