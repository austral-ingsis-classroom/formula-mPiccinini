package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.operations.one_element_operations.AbsoluteValue;
import edu.austral.ingsis.math.operations.two_element_operations.*;
import edu.austral.ingsis.math.operations.values.Number;
import edu.austral.ingsis.math.operations.values.Variable;
import org.junit.jupiter.api.Test;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "(1.0 + 6.0)";
    Function function = new Add(new Number(1d), new Number(6d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "(12.0 / 2.0)";
    Function function = new Divide(new Number(12d), new Number(2d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    final String expected = "((9.0 / 2.0) * 3.0)";
    Function function = new Multiply(new Divide(new Number(9d), new Number(2d)), new Number(3d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    final String expected = "((27.0 / 6.0) ^ 2.0)";
    Function function = new Elevate(new Divide(new Number(27d), new Number(6d)), new Number(2d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "(|value| - 8.0)";
    Function function = new Subtract(new AbsoluteValue(new Variable("value", 0d)), new Number(8d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    final String expected = "((5.0 - i) * 8.0)";
    Function function =
        new Multiply(new Subtract(new Number(5d), new Variable("i", 0d)), new Number(8d));
    final String result = function.toString();

    assertThat(result, equalTo(expected));
  }
}
