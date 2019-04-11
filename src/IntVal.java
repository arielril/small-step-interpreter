/**
 * IntVal
 */
public class IntVal extends AritExpression {
  private int val;

  public IntVal(int val) {
    this.val = val;
  }

  public int getVal() {
    return this.val;
  }

  @Override
  AritExpression smallStep(Environment a) {
    return null;
  }
  
}