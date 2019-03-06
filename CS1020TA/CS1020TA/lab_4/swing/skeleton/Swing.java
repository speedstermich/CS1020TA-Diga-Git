/**
* Name:
* Matric Number:
*/

import java.util.*;

public class Swing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> previousTrees = new Stack<>();
        long count = 0;

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int nextTree = sc.nextInt();
            while (!previousTrees.isEmpty() && previousTrees.peek() < nextTree) {
                previousTrees.pop();
                count++;
            }
            if (!previousTrees.isEmpty() && previousTrees.peek() >= nextTree) {
                count++;
            }
            if (previousTrees.isEmpty() || previousTrees.peek() != nextTree) {
                previousTrees.push(nextTree);
            }
        }
        System.out.println(count);
    }
}
