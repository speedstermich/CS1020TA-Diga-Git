/**
 *	Name	  :
 *	Matric no.:
 */

import java.util.*;
import java.io.*;

public class DNA {
    
    // attributes
    HashMap<String, Integer> sequenceCount;

    public void run() {
        sequenceCount = new HashMap<>();

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = sc.nextInt();
        int K = sc.nextInt();

        String strand = sc.next();
        generate(strand, K);

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int count = count(sc.next());
            System.out.println(count);
        }
    }
    
    /**
     *	generate		: use this method to generate/pre-process the substrings of length K from DNA
     *	Pre-condition	:
     *	Post-condition	:
     */
    public void generate(String dna, int length) {
        if (dna.length() < length) {
            return;
        }
        char[] dnaArray = dna.toCharArray();
        StringBuilder subsequence = new StringBuilder(dna.substring(0, length));
        sequenceCount.put(subsequence.toString(), 1);
        for (int i = length; i < dnaArray.length; i++) {
            subsequence.deleteCharAt(0);
            subsequence.append(dnaArray[i]);
            addOrIncrementToCount(subsequence.toString());
        }
    }
    
    private void addOrIncrementToCount(String subsequence) {
        if (sequenceCount.containsKey(subsequence)) {
            int prevCount = sequenceCount.get(subsequence);
            sequenceCount.put(subsequence, prevCount + 1);
        } else {
            sequenceCount.put(subsequence, 1);
        }
    }

    /**
     *	count			: use this method to answer one query.
     *	Pre-condition	:
     *	Post-condition	:
     */
    public int count(String substring) {
        int count = 0;
        if (sequenceCount.containsKey(substring)) {
            count = sequenceCount.get(substring);
        }
        return count;
    }

    public static void main(String[] args) {
        DNA dna = new DNA();
        dna.run();
    }
}
