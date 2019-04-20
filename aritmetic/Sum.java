package aritmetic;

import common.Environment;

/**
 * Sum
 */
public class Sum extends AritExpression {
  private AritExpression e1;
  private AritExpression e2;
  
  /**
   * Constructor for the class Sum
   * 
   * @param e1 Aritmetic Expression 1
   * @param e2 Aritmetic Expression 2
   */
  public Sum(AritExpression e1, AritExpression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  public AritExpression smallStep(Environment e) {
    if(!(e1 instanceof IntVal))
      return new Sum(e1.smallStep(e), e2);
    else if (!(e2 instanceof IntVal)) 
      return new Sum(e1, e2.smallStep(e));
    else 
      return new IntVal(((IntVal) e1).getVal() + ((IntVal) e2).getVal());
  }

  @Override
  public String toString() {
    return "(" + this.e1.toString() + " + " + this.e2.toString() + ")";
  }
}