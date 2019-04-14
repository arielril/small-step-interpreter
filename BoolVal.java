/**
 * BoolVal
 */
public class BoolVal extends BoolExpression {
  private boolean val;

  public BoolVal(boolean val) {
    this.val = val;
  }

  public boolean getVal() {
    return this.val;
  }

  @Override
  BoolExpression smallStep(Environment a) {
    return this;
  }
  
  @Override
  public String toString() {
    return String.valueOf(this.getVal());
  }
}