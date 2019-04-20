package command;

import common.AbstractSyntaxTree;
import common.Environment;

/**
 * CommandExpression
 */
public abstract class CommandExpression extends AbstractSyntaxTree {
  public abstract CommandExpression smallStep(Environment e);
}