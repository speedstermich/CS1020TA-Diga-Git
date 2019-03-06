/**
 *
 * author	: [Diga Widyaprana]
 * matric no: [A0114171W]
 * 
 */

import java.util.*;

public class HelloWorld {
	
    final static String AND = "AND";
    final static String OR = "OR";

	public static void main(String[] args) throws Exception {

		// declare the necessary variables
        int type;

		// declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

		// read input and process them accordingly
        type = sc.nextInt();

        switch (type) {
            case 1:
                int n = sc.nextInt();

                for (int i = 0; i < n; i++) {
                    processLine(sc);
                }

            break;

            case 2:
                while (!sc.hasNextInt()) {
                    processLine(sc);
                }
            break;

            case 3:
                while (sc.hasNext()) {
                    processLine(sc);
                }
            break;

            default:
                throw new Exception();
        }
	}

    static void processLine(Scanner sc) {
        String operator = sc.next();
        boolean op1 = sc.nextInt() == 1;
        boolean op2 = sc.nextInt() == 1;
        if (operate(operator, op1, op2)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static boolean operate(String operation, boolean operand1, boolean operand2) {
        if (operation.equals(AND)) {
            return operand1 && operand2;
        } else {
            return operand1 || operand2;
        }
    }
}
