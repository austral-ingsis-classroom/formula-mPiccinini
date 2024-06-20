package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.one_element_operations.AbsoluteValue;
import edu.austral.ingsis.math.operations.two_element_operations.*;
import edu.austral.ingsis.math.operations.values.Number;
import edu.austral.ingsis.math.operations.values.Variable;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    final Double expected = 4d;
    Variable x = new Variable("x", 3d);
    Function function = new Add(new Number(1d), x);
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    final Double expected = 3d;
    Variable div = new Variable("div", 4d);
    Function function = new Divide(new Number(12d), div);
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    final Double expected = 12d;
    Variable x = new Variable("x", 3d);
    Variable y = new Variable("y", 4d);
    Function function = new Multiply(new Divide(new Number(9d), x), y);
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    final Double expected = 27d;
    Variable a = new Variable("a", 9d);
    Variable b = new Variable("b", 3d);
    Function function = new Elevate(new Divide(new Number(27d), a), b);
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    final Double expected = 6d;
    Variable z = new Variable("z", 36d);
    Function function = new Elevate(z, new Number(0.5d));
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    final Double expected = 0d;
    Variable value = new Variable("value", 8d);
    Function function = new Subtract(new AbsoluteValue(value), new Number(8d));
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    final Double expected = 0d;
    Variable value = new Variable("value", 8d);
    Function function = new Subtract(new AbsoluteValue(value), new Number(8d));
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    final Double expected = 24d;
    Variable i = new Variable("i", 2d);
    Function function = new Multiply(new Subtract(new Number(5d), i), new Number(8d));
    final Double result = function.solve();

    assertThat(result, equalTo(expected));
  }
}
