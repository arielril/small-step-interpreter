package booleanpkg;

import common.Environment;

/**
 * BoolNot
 */
public class Not extends BoolExpression {
  private BoolExpression exp;

  /**
   * Constructor for the class BoolNot
   * 
   * @param exp Boolean Expression
   */
  public Not(BoolExpression exp) {
    this.exp = exp;
  }

  @Override
  public BoolExpression smallStep(Environment e) {
    if (!(exp instanceof BoolVal)) 
      return new Not(exp.smallStep(e));
    else
      return new BoolVal(!((BoolVal) exp).getVal());
  }

  @Override
  public String toString() {
    return "!" + exp.toString();
  }
}