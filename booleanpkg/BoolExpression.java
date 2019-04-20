package booleanpkg;

import common.AbstractSyntaxTree;
import common.Environment;

/**
 * BoolExpression
 */
public abstract class BoolExpression extends AbstractSyntaxTree {
  public abstract BoolExpression smallStep(Environment e);
}