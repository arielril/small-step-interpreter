/**
 * Sum
 */
public class Sum extends AritExpression {
  private AritExpression e1;
  private AritExpression e2;
  
  public Sum(AritExpression e1, AritExpression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  AritExpression smallStep(Environment a) {
    if(!(e1 instanceof IntVal))
      return new Sum((AritExpression) e1.smallStep(a), e2);
    else if (!(e2 instanceof IntVal)) 
      return new Sum(e1, (AritExpression) e2.smallStep(a));
    else 
      return new IntVal(((IntVal) e1).getVal() + ((IntVal) e2).getVal());
  }
}