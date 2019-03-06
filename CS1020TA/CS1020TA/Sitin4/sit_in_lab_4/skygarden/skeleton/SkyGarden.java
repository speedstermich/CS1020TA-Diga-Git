/**
* Name        :
* Matric No.  :
* PLab Acc.   :
*/

import java.util.*;

public class SkyGarden {
    private int something;

    public void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Stack<Pair> condensedFrontPeople = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentHeight = sc.nextInt();
            int canSee = 1; // himself

            while (!condensedFrontPeople.empty()) {
                int prevHeight = condensedFrontPeople.peek().getFirst();

                // If person in front is of same height of taller, current person
                // cannot see any further.
                if (currentHeight <= prevHeight) {
                    break;
                }

                // If person in front is shorter, current person can see whatever
                // that front person is seeing.

                // Pop from stack because the next person in line can either see
                // whatever the current person is seeing (taller) or cannot see
                // any further because blocked by the current person
                // (same height or shorter)
                Pair state = condensedFrontPeople.pop();
                canSee += state.getSecond();
            }
            Pair currentPair = new Pair(currentHeight, canSee);
            condensedFrontPeople.push(currentPair);
            System.out.print(canSee);
            if (i < n - 1) {
                System.out.print(" "); // Space following each output
            } else {
                System.out.println(); // except for the last output, in which print newline
            }
        }
    }

    public static void main(String[] args) {
        SkyGarden sg = new SkyGarden();
        sg.run();
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    public void setFirst(int newFirst) {
        this.first = newFirst;
    }

    public void setSecond(int newSecond) {
        this.second = newSecond;
    }
}
