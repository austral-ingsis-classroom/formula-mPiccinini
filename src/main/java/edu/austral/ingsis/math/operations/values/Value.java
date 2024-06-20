package edu.austral.ingsis.math.operations.values;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionEnum;

import java.util.Optional;
import java.util.Set;

public abstract class Value<T> implements Function {
    protected final T value;

    Value(T value) {
        this.value = value;
    }

    @Override
    public abstract double solve();

    @Override
    public abstract String toString();

    @Override
    public Optional<Set<String>> getVariables() {
        if (this.getType() == FunctionEnum.VARIABLE) {
            return Optional.of(Set.of(value.toString()));
        }
        return Optional.empty();
    }

    @Override
    public abstract FunctionEnum getType();
}
