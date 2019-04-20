package command;

import booleanpkg.BoolExpression;
import common.Environment;

/**
 * While
 */
public class While extends CommandExpression {
  BoolExpression boolExp;
  CommandExpression cmd;

  public While(BoolExpression boolExp, CommandExpression cmd) {
    this.boolExp = boolExp;
    this.cmd = cmd;
  }

  @Override
  public CommandExpression smallStep(Environment e) {
    return new IfThenElse(
      // bool
      boolExp,
      // if
      new Sequencial(
        cmd, 
        new While(boolExp, cmd)
      ),
      // else
      new Skip()
    );
  }

  @Override
  public String toString() {
    StringBuilder whileCmd = new StringBuilder("while ");

    whileCmd.append("(");
    whileCmd.append(boolExp.toString());
    whileCmd.append(")");
    
    whileCmd.append(" { ");
    whileCmd.append(cmd.toString());
    whileCmd.append(" }");

    return whileCmd.toString();
  }
}