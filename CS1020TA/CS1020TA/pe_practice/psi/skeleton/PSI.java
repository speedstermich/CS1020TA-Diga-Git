import java.util.*;

public class PSI {
    static int[] array;
    static int[] sumUpTo;
    static int N;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }

        sumUpTo = new int[N];

        int sumSoFar = 0;
        int psi = 0;
        for (int i = 0; i < N; i++) {
            sumSoFar += array[i];
            sumUpTo[i] = sumSoFar;
            if (sumSoFar > 0) {
                psi++;
            }
        }

        for (int i = 1; i < N; i++) {
            psi += psiStartingFrom(i);
        }

        System.out.println(psi);
	}

    // pre-cond: index > 0
    static int psiStartingFrom(int index) {
        int psi = 0;
        for (int i = index; i < N; i++) {
            int sum = sumUpTo[i] - array[index - 1];
            sumUpTo[i] = sum;
            if (sum > 0) {
                psi++;
            }
        }
        return psi;
    }

}
