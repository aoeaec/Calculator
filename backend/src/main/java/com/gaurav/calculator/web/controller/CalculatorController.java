package com.gaurav.calculator.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;
import com.gaurav.calculator.model.integration.CalculatorResponse;
import com.gaurav.calculator.model.integration.MathematicalOperator;
import com.gaurav.calculator.service.CalculatorService;
import io.swagger.annotations.Api;

@RestController(value = "CalculatorAPI")
@RequestMapping(value = "calculatorV1")
@Api(value = "view", description = "Calculator API")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping(value = "/{operator}", produces = {"application/json"})
    public CalculatorResponse operate(@PathVariable String operator,
                                  @RequestParam (required=false, defaultValue = "0") double op1,
                                  @RequestParam (required=false, defaultValue = "0") double op2) throws InvalidEntryException, InsufficientElementsException {

        return calculatorService.calculate(operator, op1, op2);

    }

    @GetMapping(value = "/operations", produces = {"application/json"})
    public List<MathematicalOperator> getOperations() {
        return calculatorService.getOperations();
    }
}
