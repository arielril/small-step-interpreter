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

  public String getName() {
    return this.name;
  }

  @Override
  public AritExpression smallStep(Environment a) {
    return a.get(this);
  }

  @Override
  public String toString() {
    return "Var " + getName();
  }
}