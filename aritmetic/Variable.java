package aritmetic;

import common.Environment;

/**
 * Variable
 */
public class Variable extends AritExpression {
  private String name;

  /**
   * Constructor for the class Variable
   * 
   * @param name Variable name
   */
  public Variable(String name) {
    this.name = name;
  }

  /**
   * Gets the name of the variable
   * 
   * @return The name of the variable
   */
  public String getName() {
    return this.name;
  }

  @Override
  public AritExpression smallStep(Environment e) {
    return e.get(this);
  }

  @Override
  public String toString() {
    return "Var " + getName();
  }
}