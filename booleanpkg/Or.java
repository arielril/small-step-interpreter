package booleanpkg;

import common.Environment;

/**
 * BoolOr
 */
public class Or extends BoolExpression {
  private BoolExpression exp1;
  private BoolExpression exp2;

  /**
   * Constructor for the class BoolOr
   * @param exp1 Expression 1
   * @param exp2 Expression 2
   */
  public Or(BoolExpression exp1, BoolExpression exp2) {
    this.exp1 = exp1;
    this.exp2 = exp2;
  }

  @Override
  public BoolExpression smallStep(Environment e) {
    if (!(exp1 instanceof BoolVal))
      return new Or(exp1.smallStep(e), exp2);
    else if (!(exp2 instanceof BoolVal))
      return new Or(exp1, exp2.smallStep(e));
    else
      return new BoolVal(((BoolVal) exp1).getVal() || ((BoolVal) exp2).getVal());
  }

  @Override
  public String toString() {
    return this.exp1.toString() + " || " + this.exp2.toString();
  }
  
}