package edu.austral.ingsis.math.operations.values;

import edu.austral.ingsis.math.FunctionEnum;

public class Number extends Value<Double> {
  public Number(Double value) {
    super(value);
  }

  @Override
  public double solve() {
    return this.value;
  }

  @Override
  public String toString() {
    return this.value.toString();
  }

  @Override
  public FunctionEnum getType() {
    return FunctionEnum.NUMBER;
  }
}
