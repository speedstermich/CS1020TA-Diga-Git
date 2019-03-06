/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class Result {
    // declare the member field

    // declare the constructor

	/** 
	 *	solve			: to count the number of sets of items satisfying the criteria.
	 * 		  			  (the total weight of all items in a set should not exceed the capacity of the sack)
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
	// you should determine the recurrence state(parameters) yourself.
	public int solve() {
		// implementation
		return 0;
	}
}

class Knapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		ArrayList<Integer> weights = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			weights.add(sc.nextInt());
		}

		System.out.println(solve(weights, K, 0, 0));
	}

	static int solve(ArrayList<Integer> weights, int capacity, int soFar, int curretIndex) {
		if (capacity < soFar) {
			return 0;
		}
		if (curretIndex >= weights.size()) {
			return 1;
		}
		int newSoFarIfTake = soFar + weights.get(curretIndex);
		int take = solve(weights, capacity, newSoFarIfTake, curretIndex + 1);

		int dontTake = solve(weights, capacity, soFar, curretIndex + 1);

		return take + dontTake;
	}
}