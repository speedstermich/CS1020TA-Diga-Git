/**
 *  Name          :
 *  Matric Number :
 */

import java.util.*;

public class Pair {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] strengths = new int[N];
        for (int i = 0; i < N; i++) {
            strengths[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> pairsWithCombinedStrength = new HashMap<>();

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int first = strengths[i];
                int second = strengths[j];
                int combined = first + second;
                if (pairsWithCombinedStrength.containsKey(combined)) {
                    int previous = pairsWithCombinedStrength.get(combined);
                    pairsWithCombinedStrength.put(combined, previous + 1);
                } else {
                    pairsWithCombinedStrength.put(combined, 1);
                }
            }
        }

        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : pairsWithCombinedStrength.entrySet()) {
            if (entry.getValue() > 1) {
                pairs += nchoose2(entry.getValue()) * 8;
            }
        }
        System.out.println(pairs);
	}

    static int nchoose2(int n) {
        return (n * (n-1)) / 2;
    }

    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}
