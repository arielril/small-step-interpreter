package common;

/**
 * AbstractSyntaxTree
 */
public abstract class AbstractSyntaxTree {
  public abstract AbstractSyntaxTree smallStep(Environment e);
}