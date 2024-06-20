package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.one_element_operations.AbsoluteValue;
import edu.austral.ingsis.math.operations.two_element_operations.*;
import edu.austral.ingsis.math.operations.values.Number;
import edu.austral.ingsis.math.operations.values.Variable;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Add onePlusSix = new Add(new Number(1d), new Number(6d));

        final Optional<Set<String>> result = onePlusSix.getVariables();

        assertThat(String.valueOf(result.isEmpty()), true);
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Function function = new Divide(new Number(12d), new Variable("div", 0d));

        final Optional<Set<String>> result = function.getVariables();

        assertThat(String.valueOf(result.isPresent()), true);

        assertThat(result.get(), containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Variable y = new Variable("y", 0d);
        Variable x = new Variable("x", 0d);
        Divide nineDividedByX = new Divide(new Number(9d), x);
        Function onePlusSix = new Multiply(nineDividedByX, y);

        final Optional<Set<String>> result = onePlusSix.getVariables();

        assertThat(String.valueOf(result.isPresent()), true);

        assertThat(result.get(), containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Variable a = new Variable("a", 0d);
        Variable b = new Variable("b", 0d);
        Divide twentySevenDividedByA = new Divide(new Number(27d), a);
        Function function = new Multiply(twentySevenDividedByA, b);

        final Optional<Set<String>> variables = function.getVariables();

        assertThat(String.valueOf(variables.isPresent()), true);

        assertThat(variables.get(), containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Variable z = new Variable("z", 0d);
        Divide oneDividedByTwo = new Divide(new Number(1d), new Number(2d));
        Function function = new Elevate(z, oneDividedByTwo);

        final Optional<Set<String>> variables = function.getVariables();

        assertThat(String.valueOf(variables.isPresent()), true);

        assertThat(variables.get(), containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Variable value = new Variable("value", 0d);
        AbsoluteValue absoluteValue = new AbsoluteValue(value);
        Function function = new Add(absoluteValue, new Number(8d));


        final Optional<Set<String>> variables = function.getVariables();

        assertThat(String.valueOf(variables.isPresent()), true);

        assertThat(variables.get(), containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Variable i = new Variable("i", 0d);
        Function function = new Multiply(new Subtract(new Number(5d), i), new Number(8d));


        final Optional<Set<String>> variables = function.getVariables();

        assertThat(String.valueOf(variables.isPresent()), true);

        assertThat(variables.get(), containsInAnyOrder("i"));
    }
}
