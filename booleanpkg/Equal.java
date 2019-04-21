package booleanpkg;

import aritmetic.AritExpression;
import aritmetic.IntVal;
import common.Environment;

/**
 * Equal
 */
public class Equal extends BoolExpression {
  private AritExpression exp1;
  private AritExpression exp2;

  public Equal(AritExpression exp1, AritExpression exp2) {
    this.exp1 = exp1;
    this.exp2 = exp2;
  }

  @Override
  public BoolExpression smallStep(Environment e) {
    if (!(exp1 instanceof IntVal))
      return new Equal(exp1.smallStep(e), exp2);
    else if (!(exp2 instanceof IntVal))
      return new Equal(exp1, exp2.smallStep(e));
    else
      return new BoolVal(((IntVal) exp1).getVal() == ((IntVal) exp2).getVal());
  }

  @Override
  public String toString() {
    return "(" + exp1.toString() + " == " + exp2.toString() + ")";
  }
}