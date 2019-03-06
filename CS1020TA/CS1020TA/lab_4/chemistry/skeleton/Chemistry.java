/**
 * Name          :
 * Matric number :
 */

import java.util.*;

public class Chemistry {

    private HashMap<Character, Integer> periodicTable;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Chemistry chem = new Chemistry();

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            char element = sc.next().charAt(0);
            int mass = sc.nextInt();
            chem.putElement(element, mass);
        }

        String formula = sc.next();
        int totalMass = chem.solveFormula(formula);
        System.out.println(totalMass);
    }

    public Chemistry() {
        periodicTable = new HashMap<>();
    }

    private void putElement(char symbol, int mass) {
        periodicTable.put(symbol, mass);
    }

    private int solveFormula(String formula) {
        Queue<Character> brokenDownFormula = new LinkedList<>();
        for (int i = 0; i < formula.length(); i++) {
            brokenDownFormula.add(formula.charAt(i));
        }
        return solveFormula(brokenDownFormula);
    }

    private int solveFormula(Queue<Character> brokenDownFormula) {
        Stack<Integer> toSum = new Stack<>();
        int i = 0;
        while (!brokenDownFormula.isEmpty()) {
            char token = brokenDownFormula.poll();
            if (periodicTable.get(token) != null) { // an element
                toSum.push(periodicTable.get(token));
            } else if (token == '(') {
                toSum.push(solveFormula(brokenDownFormula));
            } else if (token == ')') {
                return sum(toSum);
            } else { // a number
                int multiplier = Integer.parseInt(Character.toString(token));
                int previous = toSum.pop();
                toSum.push(multiplier * previous);
            }
            i++;
        }
        return sum(toSum);
    }

    private int sum(Stack<Integer> toSum) {
        int totalMass = 0;
        while (!toSum.empty()) {
            totalMass += toSum.pop();
        }
        return totalMass;
    }
}
