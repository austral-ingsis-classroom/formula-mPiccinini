package edu.austral.ingsis.math;

import java.util.Optional;
import java.util.Set;

public interface Function {
  double solve();

  String toString();

  Optional<Set<String>> getVariables();

  FunctionEnum getType();
}
