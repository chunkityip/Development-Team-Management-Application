package view;

import java.util.Scanner;

/**
 * @Description The TSUtility.java class is provided in the project,
 * which can be used to facilitate keyboard access.
 */
public class TSUtility {
    private static Scanner scanner = new Scanner (System.in);

    /**
     * @Description This method reads the keyboard, and if the user types any character in '1'-'4', the method returns.
     * The return value is the character typed by the user
     */

    public static char readMenuSelection() {
        char c;
        //we can try for(;;) , same meaning of while(true)
        while (true) {
            String s = readKeyBoard(1 , false);
            c = s.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("No such of option , Please enter again: ");
            } else break;
        }
        return c;
    }

    /**
     * @Description This method prompts and waits until the user presses the enter key and then returns
     */
      public static void readReturn() {
          System.out.print("Press enter to continue....");
          readKeyBoard(100 , true);
      }

    /**
     * This method reads an integer with a length of no more than 2 digits from the keyboard
     * and uses it as the return value of the method
     */
        public static int readInt() {
            int n;
            while (true) {
                String s = readKeyBoard(2 , false);
                try {
                    n = Integer.parseInt(s);
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("User input incorrect , please enter again: ");
                }
            }
            return n;
        }

    /**
     * Read ‘Y’ or ‘N’ from the keyboard and use it as the return value of the method
     */
        public static char readConfirmSelection() {
            char c;
            while (true) {
                String s = readKeyBoard(1 , false).toUpperCase();
                c = s.charAt(0);
                if (c == 'Y' || c == 'N') {
                    break;
                } else {
                    System.out.println("User input incorrect , please enter again: ");
                }
            }
            return c;
        }

        private static String readKeyBoard(int limit , boolean blankReturn) {
            String line = "";

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.length() == 0) {
                    if (blankReturn) return line;
                    else continue;
                }

                if (line.length() < 1 || line.length() > limit) {
                    System.out.print("The length of input (No longer to " + limit + "incorrect , please enter again: ");
                    continue;
                }
                break;
            }
            return line;
        }
}




