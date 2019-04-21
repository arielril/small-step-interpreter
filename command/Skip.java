package command;

import common.Environment;

/**
 * Skip
 */
public class Skip extends CommandExpression {

  @Override
  public CommandExpression smallStep(Environment e) {
    return this;
  }
  
  @Override
  public String toString() {
    return " SKIP ";
  }
}