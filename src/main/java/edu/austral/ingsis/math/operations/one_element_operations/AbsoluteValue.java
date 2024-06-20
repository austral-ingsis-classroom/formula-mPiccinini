package edu.austral.ingsis.math.operations.one_element_operations;

import edu.austral.ingsis.math.Function;

public class AbsoluteValue extends OneElementOperation {
    public AbsoluteValue(Function element) {
        super(element);
    }

    @Override
    public double solve() {
        return Math.abs(element.solve());
    }

    @Override
    public String toString() {
        return "|" + element.toString() + "|";
    }
}
