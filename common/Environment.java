package common;

import java.util.HashMap;
import java.util.Map;

import aritmetic.IntVal;
import aritmetic.Variable;

/**
 * Environment
 */
public class Environment {
  private Map<Variable, IntVal> mapping = new HashMap<>();

  /**
   * Add the variable with a value to the environment
   * @param variable Variable name
   * @param value    Variable value
   */
  public void add(Variable variable, IntVal value) {
    mapping.put(variable, value);
  }

  /**
   * Updates the value of a variable
   * @param variable Variable name
   * @param value    Variable value
   */
  public void update(Variable variable, IntVal value) {
    mapping.replace(variable, value);
  }

  /**
   * Gets the value of a variable
   * @param variable Variable name
   * @return The value of the requested variable
   */
  public IntVal get(Variable variable) {
    return mapping.get(variable);
  }

  @Override
  public String toString() {
    StringBuilder env = new StringBuilder("[ ");
    var iterator = mapping.entrySet().iterator();
    while (iterator.hasNext()) {
      var e = iterator.next();
      env.append(e.getKey().getName());
      env.append(" |-> ");
      env.append(e.getValue().getVal());
      if (iterator.hasNext()) 
        env.append(", ");
    }

    env.append(" ]");
    return env.toString();
  }
}