/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

public class Stick {
	static int target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        target = sc.nextInt();

        int[] sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = sc.nextInt();
        }

        int answer = solve(sticks, 0, 0, 0);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);
	}

    static int solve(int[] sticks, int sticksUsed, int lengthSoFar, int index) {
        if (lengthSoFar == target) {
            return sticksUsed;
        }
        if (index == sticks.length) {
            return Integer.MAX_VALUE;
        }
        
        int use = solve(sticks, sticksUsed + 1, lengthSoFar + sticks[index], index + 1);
        int dontUse = solve(sticks, sticksUsed, lengthSoFar, index + 1);
        return Math.min(use, dontUse);
    }
}