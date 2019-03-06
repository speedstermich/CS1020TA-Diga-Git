/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class Result {
    // declare the member field

    // declare the constructor

	/**
	 * 	solveMin		: to find the minimum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
	public int solveMin(Integer[] data) {
		int minProduct = Integer.MAX_VALUE;
		for (int i = 0; i < data.length - 2; i++) {
			for (int j = i+1; j < data.length - 1; j++) {
				for (int k = j+1; k < data.length; k++) {
					int candidate = data[i] * data[j] * data[k];
					if (candidate < minProduct) {
						minProduct = candidate;
					}
				}
			}
		}
		return minProduct;
	}

	/**
	 *	solveMax		: to find the maximum product of triplets.
	 * 	Pre-condition  	:
	 * 	Post-condition 	:
	 */	
	public int solveMax(Integer[] data) {
		int maxProduct = Integer.MIN_VALUE;
		for (int i = 0; i < data.length - 2; i++) {
			for (int j = i+1; j < data.length - 1; j++) {
				for (int k = j+1; k < data.length; k++) {
					int candidate = data[i] * data[j] * data[k];
					if (candidate > maxProduct) {
						maxProduct = candidate;
					}
				}
			}
		}
		return maxProduct;
	}
}

public class Triplet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		Integer[] toSearch = new Integer[N];
		list.toArray(toSearch);

		if (list.size() > 6) {
			Integer[] top3Bottom3 = new Integer[6];

			int max = Integer.MAX_VALUE;
			for (int i = 0; i < 3; i++) {
				max = getMax(list);
				list.remove((Integer)max);
				top3Bottom3[i] = max;
			}

			int min = Integer.MIN_VALUE;
			for (int i = 0; i < 3; i++) {
				min = getMin(list);
				list.remove((Integer)min);
				top3Bottom3[i + 3] = min;
			}
			toSearch = top3Bottom3;
		}

		Result result = new Result();

		System.out.printf("%d %d\n", result.solveMin(toSearch), result.solveMax(toSearch));
	}

	static int getMin(List<Integer> list) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}
		}
		return min;
	}

	static int getMax(List<Integer> list) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > max) {
				max = list.get(i);
			}
		}
		return max;
	}
}
