package edu.austral.ingsis.math.operations.two_element_operations;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.FunctionEnum;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

abstract class TwoElementOperation implements Function {
  protected final Function elementA;
  protected final Function elementB;

  public TwoElementOperation(Function elementA, Function elementB) {
    this.elementA = elementA;
    this.elementB = elementB;
  }

  @Override
  public abstract double solve();

  @Override
  public abstract String toString();

  @Override
  public final Optional<Set<String>> getVariables() {
    return getAllVariables();
  }

  private Optional<Set<String>> getAllVariables() {
    // Get the variables from both elements
    Optional<Set<String>> variablesA = elementA.getVariables();
    Optional<Set<String>> variablesB = elementB.getVariables();

    // If both elements have variables, return the union of both
    if (variablesA.isPresent() && variablesB.isPresent()) {
      Set<String> variables = new HashSet<>(variablesA.get());
      variables.addAll(variablesB.get());
      return Optional.of(variables);
    } else if (variablesA.isPresent()) {
      return variablesA;
    } else if (variablesB.isPresent()) {
      return variablesB;
    }

    // If none of the elements have variables, return an empty optional
    return Optional.empty();
  }

  @Override
  public final FunctionEnum getType() {
    return FunctionEnum.OPERATION;
  }
}
