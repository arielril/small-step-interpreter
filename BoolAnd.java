/**
 * BoolAnd
 */
public class BoolAnd extends BoolExpression {
  private BoolExpression e1;
  private BoolExpression e2;
  
  public BoolAnd(BoolExpression e1, BoolExpression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }

  @Override
  BoolExpression smallStep(Environment a) {
    if (!(e1 instanceof BoolVal)) 
      return new BoolAnd(e1.smallStep(a), e2);
    else if (!(e2 instanceof BoolVal)) 
      return new BoolAnd(e1, e2.smallStep(a));
    else 
      return new BoolVal(((BoolVal) e1).getVal() && ((BoolVal) e2).getVal());
  }
  
  @Override
  public String toString() {
    return this.e1.toString() + " && " + this.e2.toString();
  }
}