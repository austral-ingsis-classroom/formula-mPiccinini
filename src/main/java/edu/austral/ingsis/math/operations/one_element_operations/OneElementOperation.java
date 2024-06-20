package edu.austral.ingsis.math.operations.one_element_operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionEnum;

import java.util.Optional;
import java.util.Set;

public abstract class OneElementOperation implements Function {
    protected final Function element;

    OneElementOperation(Function element) {

        this.element = element;
    }

    @Override
    public abstract double solve();

    @Override
    public abstract String toString();

    @Override
    public final Optional<Set<String>> getVariables() {
        return element.getVariables();
    }

    @Override
    public final FunctionEnum getType() {
        return FunctionEnum.OPERATION;
    }
}
