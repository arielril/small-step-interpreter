/**
 * AritExpression
 */
public abstract class AritExpression extends AbstractSyntaxTree {
  abstract AritExpression smallStep(Environment a);
}