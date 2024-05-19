package hw4;

import exceptions.EmptyException;
import java.util.Scanner;


/**
 * A program for an RPN calculator that uses a stack.
 */
public final class Calc {


  /**
   * Attempts to add the two most recently added elements of a linked stack of integers.
   * If successful, pushes the sum onto the stack, removing the two addends first.
   * Handles appropriate exceptions (i.e. the stack is missing one or both addends)
   * @param s the LinkedStack of type integer on which the addition will be performed
   */
  public static void add(LinkedStack<Integer> s) {
    double top = 0.5;
    double beforeTop = 0.5;
    try {
      top = s.top();
      s.pop();
      beforeTop = s.top();
      s.pop();
      int sum = (int) top + (int) beforeTop;
      s.push(sum);
    } catch (EmptyException e) {
      System.out.println("ERROR: nothing to add");
      handleExceptionalCase(s, top, beforeTop);
    }

  }

  /**
   * Attempts to subtract the two most recently added elements of a linked stack of integers.
   * If successful, pushes the difference onto the stack, removing the subtracted numbers first.
   * Handles appropriate exceptions (i.e. the stack is missing one or both numbers)
   * @param s the LinkedStack of type integer on which the subtraction will be performed
   */

  public static void sub(LinkedStack<Integer> s) {
    double top = 0.5;
    double beforeTop = 0.5;
    try {
      top = s.top();
      s.pop();
      beforeTop = s.top();
      s.pop();
      int dif = (int) beforeTop - (int) top;
      s.push(dif);
    } catch (EmptyException e) {
      System.out.println("ERROR: nothing to subtract");
      handleExceptionalCase(s, top, beforeTop);
    }

  }

  /**
   * Attempts to multiply the two most recently added elements of a linked stack of integers.
   * If successful, pushes the product onto the stack, removing the multiplied numbers first.
   * Handles appropriate exceptions (i.e. the stack is missing one or both numbers)
   * @param s the LinkedStack of type integer on which the multiplication will be performed
   */

  public static void multiply(LinkedStack<Integer> s) {
    double top = 0.5;
    double beforeTop = 0.5;
    try {
      top = s.top();
      s.pop();
      beforeTop = s.top();
      s.pop();
      int prod = (int) top * (int) beforeTop;
      s.push(prod);
    } catch (EmptyException e) {
      System.out.println("ERROR: nothing to multiply");
      handleExceptionalCase(s, top, beforeTop);
    }

  }

  /**
   * Attempts to divide the two most recently added elements of a linked stack of integers.
   * If successful, pushes the quotient onto the stack, removing the divided numbers first.
   * Handles appropriate exceptions i.e. the stack is missing one or both numbers or
   * and the divisor is zero
   * @param s the LinkedStack of type integer on which the division will be performed
   */


  public static void divide(LinkedStack<Integer> s) {
    double top = 0.5;
    double beforeTop = 0.5;
    try {
      top = s.top();
      s.pop();
      beforeTop = s.top();
      s.pop();
      int quot = (int) beforeTop / (int) top;
      s.push(quot);
    } catch (ArithmeticException e) {
      System.out.println("ERROR: Division by 0");
      handleExceptionalCase(s, top, beforeTop);
    } catch (EmptyException e) {
      System.out.println("ERROR: nothing to divide");
      handleExceptionalCase(s, top, beforeTop);
    }

  }

  /**
   * Attempts to perform the modulo operation on the two most recently added elements of a linked stack of integers.
   * If successful, pushes the remainder onto the stack, removing the divided numbers first.
   * Handles appropriate exceptions i.e. the stack is missing one or both numbers or
   * and the divisor is zero
   * @param s the LinkedStack of type integer on which the modulo operation will be performed
   */

  public static void mod(LinkedStack<Integer> s) {
    double top = 0.5;
    double beforeTop = 0.5;
    try {
      top = s.top();
      s.pop();
      beforeTop = s.top();
      s.pop();
      int rem = (int) beforeTop % (int) top;
      s.push(rem);
    } catch (ArithmeticException e) {
      System.out.println("ERROR: Division by 0");
      handleExceptionalCase(s, top, beforeTop);
    } catch (EmptyException e) {
      System.out.println("ERROR: nothing to modulo divide");
      handleExceptionalCase(s, top, beforeTop);
    }

  }

  /**
   * In the case that an exception is thrown from one of the operations, this method checks whether the
   * two operands were already in the stack using the mechanism initiated in the other methods, in which
   * they are initialized as doubles with fractional values (0.5) that no integer can have, so that
   * in the case that they already exist, they can be modified to their original values and pass a check
   * for whether they were modified or not (i.e. whether they existed in the stack or not)
   * If one or both elements exist, they are pushed back onto the stack in their original order
   * @param s the LinkedStack of type integer whose elements are checked
   * @param top a value representing the initial top of the LinkedStack, if it existed; otherwise it will
   *            be a dummy double value and fail to pass a check, whereupon it is not pushed onto
   *            the stack.
   * @param beforeTop a value representing the value before the top of the LinkedStack, if it existed;
   *                  this is subject to the same check and treatment as the param top
   */

  public static void handleExceptionalCase(LinkedStack<Integer> s, double top, double beforeTop) {
    if (beforeTop != 0.5) { // i.e. it was modified in the try block, so it must have existed.
      s.push((int) beforeTop);
    }
    if (top != 0.5) {
      s.push((int) top);
    }
  }

  /**
   * The main execution method. This will handle all possible inputs except "!" which is handled in main.
   * It changes the LinkedStack accordingly. Accessed from a while loop in main()
   * @param ls the LinkedStack of type integer on which operations are performed
   * @param cur current string from user input being read
   */

  public static void evaluateLine(LinkedStack<Integer> ls, String cur) {

    if (("+").equals(cur)) {
      add(ls);
    } else if (("-").equals(cur)) {
      sub(ls);
    } else if (("*").equals(cur)) {
      multiply(ls);
    } else if (("/").equals(cur)) {
      divide(ls);
    } else if (("%").equals(cur)) {
      mod(ls);
    } else if (("?").equals(cur)) {
      System.out.println(ls.toString());
    } else if ((".").equals(cur)) {
      handleDisplayEmptyTopException(ls);
    } else if (!("!").equals(cur)) {
      takeIntegerOrInvalidStringInput(ls, cur);
    } // anything else is invalid input

  }

  /**
   * This method handles the exceptional case of trying to display the top element of an empty stack.
   * @param ls the LinkedStack of type integer whose top is checked and dealt with
   */

  public static void handleDisplayEmptyTopException(LinkedStack<Integer> ls) {
    try {
      int x = ls.top();
      System.out.println(x);
    } catch (EmptyException e) {
      System.out.println("ERROR: Top is empty; nothing to display");
    }
  }

  /**
   * This method handles the case of taking in inputs which are not operators or special commands;
   * that is, valid integers or invalid strings.
   * @param ls the LinkedStack of type integer whose potential inputs this method checks
   * @param cur the current string of user input to check for whether it can be converted to an int
   *            and added to the LinkedStack, ls
   */

  public static void takeIntegerOrInvalidStringInput(LinkedStack<Integer> ls, String cur) {
    try {
      int x = Integer.parseInt(cur);
      ls.push(x);
    } catch (NumberFormatException e) {
      System.out.println("ERROR: Input must be an integer, operator, or valid command");
    }
  }




  /**
   * The main function.
   *
   * @param args Not used.
   */
  public static void main(String[] args) {

    Scanner k = new Scanner(System.in);
    LinkedStack<Integer> ls = new LinkedStack<>();

    while (true) {

      boolean quit = false;
      String line = k.nextLine();
      Scanner l = new Scanner(line);

      while (l.hasNext()) {
        String cur = l.next();
        evaluateLine(ls, cur);
        if (("!").equals(cur)) {
          quit = true;
          break;
        }
      }

      if (quit) {
        break;
      }
    }

  }


}

