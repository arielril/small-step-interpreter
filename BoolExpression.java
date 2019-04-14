/**
 * BoolExpression
 */
public abstract class BoolExpression extends AbstractSyntaxTree {
  abstract BoolExpression smallStep(Environment a);
}