import aritmetic.*;
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

  public static void main(String[] args) {
    System.out.println("Running the parser :D !\n");

    simpleSum();

  }
}