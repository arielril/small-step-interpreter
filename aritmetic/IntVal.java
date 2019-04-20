package aritmetic;

import common.Environment;

/**
 * IntVal
 */
public class IntVal extends AritExpression {
  private int val;

  /**
   * Constructor for the class IntVal
   * 
   * @param val The value of the IntVal
   */
  public IntVal(int val) {
    this.val = val;
  }

  /**
   * Gets the value of the IntVal
   * 
   * @return The value of the IntVal
   */
  public int getVal() {
    return this.val;
  }

  @Override
  public AritExpression smallStep(Environment e) {
    return this;
  }

  @Override
  public String toString() {
    return String.valueOf(this.getVal());
  }
}