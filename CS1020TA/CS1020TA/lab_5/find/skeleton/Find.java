/**
 *	name	  :
 *	matric no.:
 */

import java.util.*;

class Result {

    // declare the member field

    // declare the constructor

	/**
	 *	generate		: use this method to generate/pre-process the substrings of length K from string-idx, 
	 *					  either first string or second string
	 *	Pre-condition	:
	 *	Post-condition	:
	 */
	public void generate(String dna, int idx) {
		// implementation
		return;
	}

	/**
	 *	find			: use this method to check whether a particular substring exists in string-idx, 
	 *				  	  either first string, or second string
	 *	Pre-condition	:
	 *	Post-condition	:
	 */
	public boolean find(String substring, int idx) {
		// implementation
		return true;
	}
}

class Find {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		String strand1 = sc.next();
		String strand2 = sc.next();

		HashSet<String> set1 = generate(strand1, K);
		HashSet<String> set2 = generate(strand2, K);

		int Q = sc.nextInt();

		for (int i = 0; i < Q; i++) {
			String subsequence = sc.next();
			int output = 0;
			if (set1.contains(subsequence) && set2.contains(subsequence)) {
				output = 3;
			} else if (set2.contains(subsequence)) {
				output = 2;
			} else if (set1.contains(subsequence)) {
				output = 1;
			}
			System.out.println(output);
		}
	}

	private static HashSet<String> generate(String dna, int length) {
		HashSet<String> set = new HashSet<>();

		if (dna.length() < length) {
            return set;
        }

        char[] dnaArray = dna.toCharArray();
        StringBuilder subsequence = new StringBuilder(dna.substring(0, length));
        set.add(subsequence.toString());
        for (int i = length; i < dnaArray.length; i++) {
            subsequence.deleteCharAt(0);
            subsequence.append(dnaArray[i]);
            set.add(subsequence.toString());
        }
        return set;
	}
}