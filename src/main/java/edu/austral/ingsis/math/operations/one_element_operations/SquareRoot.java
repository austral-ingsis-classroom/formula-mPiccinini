package edu.austral.ingsis.math.operations.one_element_operations;

import edu.austral.ingsis.math.Function;

public class SquareRoot extends OneElementOperation {
  public SquareRoot(Function element) {
    super(element);
  }

  @Override
  public double solve() {
    return Math.sqrt(element.solve());
  }

  @Override
  public String toString() {
    return "sqrt(" + element.toString() + ")";
  }
}
