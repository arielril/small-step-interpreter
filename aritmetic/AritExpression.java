package aritmetic;

import common.AbstractSyntaxTree;
import common.Environment;

/**
 * AritExpression
 */
public abstract class AritExpression extends AbstractSyntaxTree {
  public abstract AritExpression smallStep(Environment e);
}