package command;

import booleanpkg.BoolExpression;
import booleanpkg.Not;
import common.Environment;

/**
 * Definitions of the command Repeat Until
 * 
 * RepeatUntil
 * 
 * Sintaxe: repeat C until B
 * 
 * Semantica:
 * 
 * RepeatUntil _____________________________________________________________________________
 *              <repeat C until B, s> ->{c} <if B then skip else (C; repeat C until B), s> 
 * 
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