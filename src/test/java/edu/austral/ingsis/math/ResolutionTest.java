package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operations.one_element_operations.AbsoluteValue;
import edu.austral.ingsis.math.operations.two_element_operations.*;
import edu.austral.ingsis.math.operations.values.Number;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Double expected = 7d;
        Function function = new Add(new Number(1d), new Number(6d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Double expected = 6d;
        Function function = new Divide(new Number(12d), new Number(2d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Double expected = 13.5;
        Function function = new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Double expected = 20.25;
        Function function = new Elevate(new Divide(new Number(27d), new Number(6d)), new Number(2d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Double expected = 6d;
        Function function = new Elevate(new Number(36d), new Number(0.5d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double expected = 136d;
        Function function = new AbsoluteValue(new Number(136d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double expected = 136d;
        Function function = new AbsoluteValue(new Number(-136d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Double expected = 0d;
        Function function = new Multiply(new Subtract(new Number(5d), new Number(5d)), new Number(8d));
        final Double result = function.solve();

        assertThat(result, equalTo(expected));
    }
}
