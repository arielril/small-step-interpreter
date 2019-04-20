package command;

import common.Environment;
import booleanpkg.BoolExpression;
import booleanpkg.BoolVal;

/**
 * IfThenElse
 */
public class IfThenElse extends CommandExpression {
  BoolExpression boolExp;
  CommandExpression cmdIf;
  CommandExpression cmdElse;

  public IfThenElse(BoolExpression boolExp, CommandExpression cmdIf, CommandExpression cmdElse) {
    this.boolExp = boolExp;
    this.cmdIf = cmdIf;
    this.cmdElse = cmdElse;
  }

  @Override
  public CommandExpression smallStep(Environment e) {
    if (!(boolExp instanceof BoolVal)) 
      return new IfThenElse(boolExp.smallStep(e), cmdIf, cmdElse);
    
    // the boolean expression is a boolean value
    if (((BoolVal) boolExp).getVal())
      return cmdIf.smallStep(e);
    else 
      return cmdElse.smallStep(e);
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("if ");

    str.append("(");
    str.append(boolExp.toString());
    str.append(")");

    str.append(" { ");
    str.append(cmdIf.toString());
    str.append("} ");

    str.append("else");
    str.append(" {");
    str.append(cmdElse.toString());
    str.append(" }");



    return str.toString();
  }
}