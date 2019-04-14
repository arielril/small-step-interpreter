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
  public AritExpression smallStep(Environment a) {
    return this;
  }

  @Override
  public String toString() {
    return String.valueOf(this.getVal());
  }
}