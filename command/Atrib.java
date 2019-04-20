package command;

import aritmetic.AritExpression;
import aritmetic.IntVal;
import aritmetic.Variable;
import common.Environment;

/**
 * Atrib
 */
public class Atrib extends CommandExpression {
  private Variable variable;
  private AritExpression value;

  public Atrib(Variable variable, AritExpression value) {
    this.variable = variable;
    this.value = value;
  }

  @Override
  public CommandExpression smallStep(Environment e) {
    if (!(value instanceof IntVal)) 
      return new Atrib(variable, value.smallStep(e));

    // update all ocurrences of the variable with the new value
    e.update(variable, (IntVal) value);
    // return SKIP with the new state
    return new Skip();
  
  }

  @Override
  public String toString() {
    return variable.toString() + " := " + value.toString();
  }
}