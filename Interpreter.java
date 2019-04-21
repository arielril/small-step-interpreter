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

  public static void simpleSum() {
    printDivider();
    System.out.println("Simple Sum:\n");
    IntVal two1 = new IntVal(2);
    IntVal two2 = new IntVal(2);

    Variable var1 = new Variable("X");
    Variable var2 = new Variable("Y");

    Environment e = new Environment();
    e.add(var1, two1);
    e.add(var2, two2);

    AritExpression s = new Sum(var1, var2);

    System.out.println("Env: " + e.toString());

    int c = 0;
    while (!(s instanceof IntVal)) {
      System.out.println("Sum small " + c + ": " + s.toString());
      s = s.smallStep(e);
      c++;
    }

    System.out.println("Sum final: " + s.toString());
    printDivider();
    System.out.println();
  }

  public static void whileEx() {
    printDivider();
    System.out.println("While exercise 1:");
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
    while (!(prog instanceof Skip)) {
      System.out.println("\nEnv: " + e.toString());
      System.out.println("Prog step " + c + ": " + prog.toString());
      prog = prog.smallStep(e);
      c++;
    }

    System.out.println("Prog final: " + prog.toString());
    printDivider();
    System.out.println();
  }

  public static void main(String[] args) {
    System.out.println("Running the parser :D !\n");

    // simpleSum();
    whileEx();
  }
}