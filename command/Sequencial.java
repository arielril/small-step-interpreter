package command;

import common.Environment;

/**
 * Sequencial
 */
public class Sequencial extends CommandExpression {
  CommandExpression cmd1;
  CommandExpression cmd2;

  public Sequencial(CommandExpression cmd1, CommandExpression cmd2) {
    this.cmd1 = cmd1;
    this.cmd2 = cmd2;
  }

  @Override
  public CommandExpression smallStep(Environment e) {
    if (!(cmd1 instanceof Skip))
      return new Sequencial(cmd1.smallStep(e), cmd2);
    
    // if cmd1 is SKIP, executes the second command
    return new Sequencial(cmd1, cmd2.smallStep(e));
  }

  @Override
  public String toString() {
    return cmd1.toString() + " ; " + cmd2.toString() ;
  }  
}