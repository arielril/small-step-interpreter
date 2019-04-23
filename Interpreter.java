import aritmetic.*;
import booleanpkg.*;
import command.*;
import common.*;

/**
 * Interpreter
 */
public class Interpreter {

  public static void printDivider() {
    System.out.println("----------------------------------------------------");
  }

  /**
   * Computes the last 2 fibonacci numbers. The results are in the A and B variables
   */
  public static void fstUsage() {
    Variable varA = new Variable("A");
    Variable varB = new Variable("B");
    Variable varI = new Variable("I");
    Variable varN = new Variable("N");
    Variable varC = new Variable("C");
    
    AbstractSyntaxTree prog = new Sequencial(
      new Atrib(varA, new IntVal(1)), 
      new Sequencial(
        new Atrib(varB, new IntVal(1)),
        new Sequencial(
          new Atrib(varI, new IntVal(1)),
          new Sequencial(
            new Atrib(varN, new IntVal(7)),
            new While(
              new Or(
                new LessThan(varI, new Sub(varN, new IntVal(2))),
                new Equal(varI, new Sub(varN, new IntVal(2)))
              ),
              new Sequencial(
                new Atrib(varC, new Sum(varA, varB)), 
                new Sequencial(
                  new Atrib(varA, varB),
                  new Sequencial(
                    new Atrib(varB, varC),
                    new Atrib(varI, new Sum(varI, new IntVal(1)))
                  )
                )
              )
            )
          )
        )
      )
    );    

    Environment e = new Environment();
    
    int c = 0;
    while (!(prog instanceof Skip) && !(prog instanceof IntVal) && !(prog instanceof BoolVal)) {
      System.out.println("Step " + c + ": " + prog.toString());
      System.out.println("\nEnv: " + e.toString());
      prog = prog.smallStep(e);
      c++;
    }

    System.out.println("Final: " + prog.toString());
  }

  public static void sndUsage() {
    var varZ = new Variable("Z");
    var varY = new Variable("Y");
    var varX = new Variable("X");

    CommandExpression zAtrib1 = new Atrib(varZ, new IntVal(0));
    CommandExpression whileCmd = new While(
      new Or(new LessThan(varY, varX), new Equal(varY, varX)),
      new Sequencial(
        new Atrib(varZ, new Sum(varZ, new IntVal(1))), 
        new Atrib(varX, new Sub(varX, varY))
      )
    );

    AbstractSyntaxTree prog = new Sequencial(zAtrib1, whileCmd);

    Environment e = new Environment();
    e.add(varX, new IntVal(17));
    e.add(varY, new IntVal(5));

    int c = 0;
    while (!(prog instanceof Skip) && !(prog instanceof IntVal) && !(prog instanceof BoolVal)) {
      System.out.println("Step " + c + ": " + prog.toString());
      System.out.println("\nEnv: " + e.toString());
      prog = prog.smallStep(e);
      c++;
    }

    System.out.println("Final: " + prog.toString());
  }

  /**
   * Computes the factorial of X
   */
  public static void trdUsage() {
    Variable varZ = new Variable("Z");
    Variable varX = new Variable("X");

    AbstractSyntaxTree prog = new RepeatUntil(
      new Sequencial(new Atrib(varZ, new Mult(varZ, varX)), new Atrib(varX, new Sub(varX, new IntVal(1)))),
      new Equal(varX, new IntVal(0))
    );

    Environment e = new Environment();
    e.add(varX, new IntVal(5));
    e.add(varZ, new IntVal(1));

    int c = 0;
    while (!(prog instanceof Skip) && !(prog instanceof IntVal) && !(prog instanceof BoolVal)) {
      System.out.println("Step " + c + ": " + prog.toString());
      System.out.println("\nEnv: " + e.toString());
      prog = prog.smallStep(e);
      c++;
    }

    System.out.println("Final: " + prog.toString());
  }

  public static void main(String[] args) {
    System.out.println("Running the parser :D !\n");

    printDivider();
    fstUsage();
    printDivider();
    System.out.println();

    printDivider();
    sndUsage();
    printDivider();
    System.out.println();

    printDivider();
    trdUsage();
    printDivider();
    System.out.println();
  }
}