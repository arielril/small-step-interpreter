/**
 * Variable
 */
public class Variable extends AritExpression {
  private String name;

  /**
   * 
   * @param name Variable name
   */
  public Variable(String name) {
    this.name = name;
  }

  @Override
  public AritExpression smallStep(Environment a) {
    return new IntVal(a.get(this.name));
  }
}