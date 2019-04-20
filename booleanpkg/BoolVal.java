package booleanpkg;

import common.Environment;

/**
 * BoolVal
 */
public class BoolVal extends BoolExpression {
  private boolean val;

  /**
   * Constructor for the class BoolVal
   * 
   * @param val Value of the boolean value class
   */
  public BoolVal(boolean val) {
    this.val = val;
  }

  /**
   * Gets the real value of the BoolVal
   * 
   * @return The value of the BoolVal class
   */
  public boolean getVal() {
    return this.val;
  }

  @Override
  public BoolExpression smallStep(Environment e) {
    return this;
  }
  
  @Override
  public String toString() {
    return String.valueOf(this.getVal());
  }
}