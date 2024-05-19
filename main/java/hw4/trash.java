package hw4;
import java.util.Scanner;


/**
 * A program for an RPN calculator that uses a stack.
 */
public class trash {
    /**
     * The main function.
     *
     * @param args Not used.
     */
    public static void main(String[] args) {

        Scanner k = new Scanner(System.in);
        while (true) {
            String input = k.nextLine();
            boolean exit = false;

            String[] inputArr = input.split(" ");
            int numInputs = inputArr.length;
            String[] revArr = new String[numInputs];

            // construct reverse array to execute statements in order of first in, first done.
            // since stacks are last in, first out must reverse the input array

            for (int i = numInputs - 1; i >= 0; i--) {
                revArr[i] = inputArr[i];
            }


            for (int i = 0; i < numInputs; i++) {
                System.out.println(inputArr[i]);
                if (inputArr[i].equals("!")) {
                    exit = true;
                    break;
                }
            }
            if (exit) {
                break;
            }

            LinkedStack<String> s = new LinkedStack<>();
            for (int i = 0; i < numInputs; i++) {
                s.push(inputArr[i]);
            }

            String[] validNonInts = {"+", "-", "*", "/", "%", "?", ".", "!"};
            int numValidNonInts = validNonInts.length;

            // plan: Go through the line of input. First check if it's a valid non-int.
            // store all valid non-ints in a stack of operators.
            // store all ints in a stack of ints.
            // ignore all invalid non-ints
            // once exclamation is reached, quit
            // if there are excess operators, then print some error

//      for (int i = 0; i < numInputs; i++) {
//        for (int j = 0; j < numValidNonInts; j++) {
//          if (revArr[i].equals(validNonInts[j])) {
//            n.push(validNonInts[j]);
//          }
//        }
//      }


            //for (int i = 0; i < numInputs; i++) {
            // if (inputArr[i].equals)
            // }

            String curr = s.top();

            // try operations first, then test if it's string using try-catch, then collect integers.

//      try {
//        int x = Integer.parseInt(input);
//        // You can use this method to convert String to int, But if input
//        //is not an int  value then this will throws NumberFormatException.
//        System.out.println("Valid input");
//      }catch(NumberFormatException e) {
//        System.out.println("input is not an int value");
//        // Here catch NumberFormatException
//        // So input is not a int.
//      }

            if (curr.equals("!")) {
                break;
            } else if (curr.equals("+")) {

            }

        }


    }
}
