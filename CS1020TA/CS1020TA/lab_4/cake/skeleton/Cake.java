/**
 * Name          :
 * Matric number :
 */

import java.util.*;

public class Cake {
    int choc;
    boolean raisin;

    public Cake(int chocolateAmount, boolean containsRaisin) {
        choc = chocolateAmount;
        raisin = containsRaisin;
    }

    public int getChocolateAmount() {
        return choc;
    }

    public boolean containsRaisin() {
        return raisin;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int maxChoc = -1;
        int currentChoc = 0;
        int currentRaisin = 0;

        Queue<Cake> candidateCakeBlock = new LinkedList<Cake>();

        for (int i = 0; i < N; i++) {
            char T = sc.next().charAt(0);
            int X = sc.nextInt();

            boolean containsRaisin = T == 'R';
            Cake block = new Cake(X, containsRaisin);

            if (containsRaisin) {
                // Sharon is at raisin limit
                if (currentRaisin >= K) {
                    Cake toRemove;
                    do {
                        // Haven't checked for null
                        toRemove = candidateCakeBlock.remove();
                        currentChoc -= toRemove.getChocolateAmount();
                    } while (!toRemove.containsRaisin());
                }
                currentRaisin++;
            }
            candidateCakeBlock.add(block);
            currentChoc += block.getChocolateAmount();
            if (maxChoc < currentChoc) {
                maxChoc = currentChoc;
            }
        }
        System.out.println(maxChoc);
	}
}
