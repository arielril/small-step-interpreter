/**
 * Sub
 */
public class Sub extends AritExpression {
  private AritExpression e1;
  private AritExpression e2;

  public Sub(AritExpression e1, AritExpression e2) {
    this.e1 = e1;
    this.e2 = e2;
  }
  
  @Override
  public AritExpression smallStep(Environment a) {
    if (!(e1 instanceof IntVal)) 
      return new Sub(e1.smallStep(a), e2);
    else if (!(e2 instanceof IntVal)) 
      return new Sub(e1, e2.smallStep(a));
    else 
      return new IntVal(((IntVal) e1).getVal() - ((IntVal) e2).getVal());
  }

  @Override
  public String toString() {
    return this.e1.toString() + "- " + this.e2.toString();
  }
}