package edu.austral.ingsis.math.operations.two_element_operations;

import edu.austral.ingsis.math.Function;

public class Multiply extends TwoElementOperation {
    public Multiply(Function elementA, Function elementB) {
        super(elementA, elementB);
    }

    @Override
    public double solve() {
        return elementA.solve() * elementB.solve();
    }

    @Override
    public String toString() {
        return "(" + elementA.toString() + " * " + elementB.toString() + ")";
    }
}
