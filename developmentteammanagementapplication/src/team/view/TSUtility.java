package team.view;

import java.util.*;
/**
 *
 * @Description The TSUtility.java class provides the function that can be used for input access.
 *
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @Description The readMenuSelection method reads the user input. If the user types
     * the numbers between 1 to 4, it will return it.
     * (The return value will be the number user entered about.)
     *
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("Selection error, please re-enter(1 to 4)：");
            } else break;
        }
        return c;
    }
	/**
	 * 
	 * @Description The readReturn method will prompt and wait until the user
     * presses the enter key to return.
	 *
	 */
    public static void readReturn() {
        System.out.print("Press Enter to continue......");
        readKeyBoard(100, true);
    }
    /**
     * 
     * @Description The readInt method reads an integer no more than 2 digits
     * from the user input and uses it as the return value of the method.
     *
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Number input error, please re-enter:");
            }
        }
        return n;
    }
    /**
     * 
     * @Description The readConfirmSelection method read ‘Y’ or ‘N’ from
     * the user input and use it as the return value
     *
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Selection error, please re-enter(Y or N)：");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("The input length (not greater than "+ limit + ") is incorrect, please re-enter:");
                continue;
            }
            break;
        }

        return line;
    }
}

