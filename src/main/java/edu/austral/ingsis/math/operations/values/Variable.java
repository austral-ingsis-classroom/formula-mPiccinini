package edu.austral.ingsis.math.operations.values;

import edu.austral.ingsis.math.FunctionEnum;

public class Variable extends Value<String> {
    private final double numericalValue;

    public Variable(String value, double numericalValue) {
        super(value);
        this.numericalValue = numericalValue;
    }

    @Override
    public double solve() {
        return numericalValue;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public FunctionEnum getType() {
        return FunctionEnum.VARIABLE;
    }
}
