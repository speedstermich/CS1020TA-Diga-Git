
/**
*	Name		:
*	Matric No.	:
*/

import java.util.*;

public class Passing {
	private LinkedList<String> players;
	private int rcvLimit;
	private int ballPos;
	private HashMap<String, Integer> playerRcvCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		Passing game = new Passing(K);

		for (int i = 0; i < N; i++) {
			game.addPlayer(sc.next());
		}

		for (int i = 0; i < M; i++) {
			System.out.println(game.run(sc.nextInt()));
		}
	}

	public Passing(int K) {
		players = new LinkedList<>();
		rcvLimit = K;
		ballPos = 0;
		playerRcvCount = new HashMap<>();
	}

	private void addPlayer(String playerName) {
		players.add(playerName);
		playerRcvCount.put(playerName, 0);
	}

	private String run(int noOfPasses) {
		int newBallPos = (ballPos + noOfPasses) % players.size();

		String reportingPlayer = players.get(newBallPos);
		// increment receive count of that player
		playerRcvCount.put(reportingPlayer, playerRcvCount.get(reportingPlayer) + 1);

		boolean isEliminated = playerRcvCount.get(reportingPlayer) >= rcvLimit;

		if (isEliminated) {
			players.remove(newBallPos);
			ballPos = newBallPos >= players.size() ? 0 : newBallPos;
		} else if (newBallPos != ballPos) {
			swap(ballPos, newBallPos);
		}

		return reportingPlayer;
	}

	private void swap(int index1, int index2) {
		String player1 = players.get(index1);
		String player2 = players.get(index2);
		players.set(index1, player2);
		players.set(index2, player1);
	}
}

// class LinkedList<E> {
// 	protected ListNode head = null;

// 	public void addAfter(E item, E after) {

// 	}

// 	public int findIndex(E item) {
// 		return 0;
// 	}
// }

// class ListNode<E> {
// 	protected E element;
// 	protected ListNode<E> next;

// 	/* constructors */
// 	public ListNode(E item) {
// 		element = item;
// 		next = null;
// 	}

// 	public ListNode(E item, ListNode<E> n) {
// 		element = item;
// 		next = n;
// 	}

// 	/* get the next ListNode */
// 	public ListNode<E> getNext() {
// 		return this.next;
// 	}

// 	/* get the element of the ListNode */
// 	public E getElement() {
// 		return this.element;
// 	}

// 	public void setNext(ListNode<E> item) {
// 		this.next = item;
// 	}

// 	public void setElement(E item) {
// 		this.element = item;
// 	}
// }
