package edu.austral.ingsis.math.operations.two_element_operations;

import edu.austral.ingsis.math.Function;

public class Elevate extends TwoElementOperation {
    public Elevate(Function elementA, Function elementB) {
        super(elementA, elementB);
    }

    @Override
    public double solve() {
        return Math.pow(elementA.solve(), elementB.solve());
    }

    @Override
    public String toString() {
        return "(" + elementA.toString() + " ^ " + elementB.toString() + ")";
    }
}
