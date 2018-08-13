package com.gaurav.calculator.model.integration;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.gaurav.calculator.exception.InsufficientElementsException;
import com.gaurav.calculator.exception.InvalidEntryException;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MathematicalOperator implements Serializable {
    ADD("add", 2, "+", "Add") {
        @Override
        public Double apply(Double... values) {
            return values[0] + values[1];

        }
    },
    SUBTRACT("subtract", 2, "-", "Subtract") {
        @Override
        public Double apply(Double... values) {
            return values[0] - values[1];
        }
    },
    POWER("power", 2, "^", "Power Of") {
        @Override
        public Double apply(Double... values) {
            return Math.pow(values[0], values[1]);

        }
    },
    MULTIPLY("multiply", 2, "*", "Multiply") {
        @Override
        public Double apply(Double... values) {
            return values[0] * values[1];

        }
    },
    DIVIDE("divide", 2, "/", "Divide") {
        @Override
        public Double apply(Double... values) throws InvalidEntryException {
            if (values[1] == 0) throw new InvalidEntryException("Cannot divide by Zero");
            return values[0] / values[1];

        }
    },
    SQUARE_ROOT("square_root", 1, "\u221A", "Square Root") {
        @Override
        public Double apply(Double... values) throws InvalidEntryException {
            if (values[0] < 0)
                throw new InvalidEntryException("Unable to do square root of negative number as result will be an complex number");
            return Math.sqrt(values[0]);
        }
    },
    LOG10("log10", 1, "log", "Log, Base 10") {
        @Override
        public Double apply(Double... values) throws InvalidEntryException {
            if (values[0] < 0)
                throw new InvalidEntryException("Unable to do Log10 of negative number as result will be an complex number");
            return Math.log10(values[0]);
        }
    },
    LN("ln", 1, "ln", "Log, Natural") {
        @Override
        public Double apply(Double... values) throws InvalidEntryException {
            if (values[0] < 0)
                throw new InvalidEntryException("Unable to do LogN of negative number as result will be an complex number");
            return Math.log(values[0]);
        }
    },
    PI("pi", 0, "\u03C0", "\u03C0") {
        @Override
        public Double apply(Double... values) {
            return Math.PI;
        }
    },
    E("e", 0, "e", "e") {
        @Override
        public Double apply(Double... values) {
            return Math.E;
        }
    };

    public String getOperation() {
        return operation;
    }

    public int getArguments() {
        return arguments;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    private final String operation;
    private final int arguments;
    private final String symbol;
    private final String description;

    MathematicalOperator(String operation, int arguments, String symbol, String description) {
        this.operation = operation;
        this.arguments = arguments;
        this.symbol = symbol;
        this.description = description;
    }

    public static MathematicalOperator parseOperator(String operator) throws InvalidEntryException {
        for (MathematicalOperator op : values()) {
            if (op.operation.equals(operator)) return op;
        }
        throw new InvalidEntryException("Illegal Operator value " + operator);
    }

    public abstract Double apply(Double... values) throws InvalidEntryException, InsufficientElementsException;

    @Override
    public String toString() {
        return "{" +
            "operation=\"" + operation + "\"" +
            ", arguments=" + arguments +
            ", symbol=\"" + symbol + '\"' +
            ", description=\"" + description + '\"' +
            '}';
    }
}

