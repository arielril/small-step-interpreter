package command;

import booleanpkg.BoolExpression;
import booleanpkg.Not;
import common.Environment;

/**
 * RepeatUntil
 */
public class RepeatUntil extends CommandExpression {
  private BoolExpression boolExp;
  private CommandExpression cmd;

  public RepeatUntil(CommandExpression cmd, BoolExpression boolExp) {
    this.boolExp = boolExp;
    this.cmd = cmd;
  }

  @Override
  public CommandExpression smallStep(Environment e) {
    return new While(
      new Not(boolExp), 
      cmd
    );
  }

  @Override
  public String toString() {
    StringBuilder repeat = new StringBuilder("repeat ");

    repeat.append(" { ");
    repeat.append(cmd.toString());
    repeat.append(" }");

    repeat.append(" until ( ");
    repeat.append(boolExp.toString());
    repeat.append(" )");

    return repeat.toString();
  }
}