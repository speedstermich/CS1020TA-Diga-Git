/**
 * Name			:
 * Matric No.	:
 */
import java.util.*;

public class Love {

    HashMap<String, Integer> wordCount;

    public Love() {
        wordCount = new HashMap<>();
    }

	public void run() {
		// treat this as your "main" method
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<String> words = new LinkedList<>();

        // To be used to generate the first candidate
        int lastIndexWithoutDuplicate = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            words.offer(word);
            if (!wordCount.containsKey(word)) {
                lastIndexWithoutDuplicate = i;
            }
            wordCount.put(word, 0);
        }

        Queue<String> candidate = new LinkedList<>();

        int strLength = 0;

        // Generate a letter containing all words from the top
        for (int i = 0; i <= lastIndexWithoutDuplicate; i++) {
            String word = words.poll();
            strLength += addWord(candidate, word);
        }

        // In case the first candidate contains duplicate words
        strLength -= removeRedundant(candidate);
        int min = strLength;

        while (!words.empty()) {
            String word = words.poll();
            strLength += addWord(candidate, word);
            strLength -= removeRedundant(candidate);
            min = Math.min(min, strLength);
        }

        System.out.println(min);
	}

    // returns the length of word
    private int addWord(Queue<String> letter, String word) {
        letter.offer(word);
        incrementCount(word);
        return word.length();
    }

    // Pre-cond: word exists in wordCount
    private void incrementCount(String word) {
        int prevCount = wordCount.get(word);
        wordCount.put(word, prevCount + 1);
    }

    // Pre-cond: word exists in wordCount
    private void decrementCount(String word) {
        int prevCount = wordCount.get(word);
        wordCount.put(word, prevCount - 1);
    }

    private int removeRedundant(Queue<String> letter) {
        int letterCount = 0;
        while (wordCount.get(letter.peek()) > 1) {
            String word = letter.poll();
            decrementCount(word);
            letterCount += word.length();
        }
        return letterCount;
    }

	public static void main(String[] args) {
		Love myLove = new Love();
		myLove.run();
	}

}
