import java.util.*;

class Instruction {
    static int target;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        target = sc.nextInt();

        ArrayList<Instruction> instructions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char operator = sc.next().toCharArray()[0];
            int operand = sc.nextInt();
            instructions.add(new Instruction(operator, operand));
        }

        System.out.println(solve(instructions, 0, 0));
	}

    static int solve(ArrayList<Instruction> inst, int soFar, int currentIndex) {
        if (currentIndex == inst.size()) {
            return soFar;
        }
        int newValueIfTake = operate(inst.get(currentIndex), soFar);

        int take = solve(inst, newValueIfTake, currentIndex + 1);
        int dontTake = solve(inst, soFar, currentIndex + 1);

        int diffTake = Math.abs(target - take);
        int diffDontTake = Math.abs(target - dontTake);

        if (diffTake < diffDontTake) {
            return take;
        } else if (diffTake > diffDontTake) {
            return dontTake;
        } else {
            return Math.min(take, dontTake);
        }
    }

    static int operate(Instruction inst, int soFar) {
        char operator = inst.getOperator();
        int operand = inst.getOperand();
        if (operator == '+') {
            return soFar + operand;
        } else if (operator == '-') {
            return soFar - operand;
        } else if (operator == '*') {
            return soFar * operand;
        } else {
            return soFar / operand;
        }
    }

    private char operator;
    private int operand;

    public Instruction(char operator, int operand) {
        this.operator = operator;
        this.operand = operand;
    }

    public char getOperator() {
        return operator;
    }

    public int getOperand() {
        return operand;
    }
}
