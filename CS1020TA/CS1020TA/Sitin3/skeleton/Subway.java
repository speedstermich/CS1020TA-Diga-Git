/**
 * Name			:
 * Matric. No	:
 * PLab Acct.	:
 */

import java.util.*;

public class Subway {

    private LinkedList<String> stations;

	public Subway() {
		stations = new LinkedList<>();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            stations.add(sc.next());
        }

        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            String output;
            String query = sc.next();
            if (query.equals("TIME")) {
                String start = sc.next();
                String end = sc.next();
                output = time(start, end);
            } else if (query.equals("BUILD")) {
                String reference = sc.next();
                String toBuild = sc.next();
                output = build(reference, toBuild);
            } else if (query.equals("PATH")) {
                String start = sc.next();
                String end = sc.next();
                output = path(start, end);
            } else { // query.equals("PRINT")
                String start = sc.next();
                output = print(start);
            }
            System.out.println(output);
        }
	}

    private String time(String startStation, String endStation) {
        int startIndex = stations.indexOf(startStation);
        int endIndex = stations.indexOf(endStation);

        // Note that minHops != noOfStationsInPath
        // In fact, minHops = noOfStationsInPath - 1
        int result = minHops(startIndex, endIndex);
        if (result != 0) {
            // So if you counted the noOfStationsInPath instead,
            // The formula below becomes
            // result = (result-1) * 3 - 1;
            result = result * 3 - 1;
            // result = result * 2 + result-1;
        }
        return Integer.toString(result);
    }

    private String build(String precedingStation, String newStation) {
        int newStationIndex = stations.indexOf(precedingStation) + 1;
        stations.add(newStationIndex, newStation);
        return "station " + newStation + " has been built";
    }

    private String path(String startStation, String endStation) {
        int startIndex = stations.indexOf(startStation);
        int endIndex = stations.indexOf(endStation);
        int minJump = minHops(startIndex, endIndex);

        boolean clockwise = (startIndex + minJump) % stations.size() == endIndex;

        return clockwise ? printStations(startIndex, minJump)
                        : printStationsCCW(startIndex, minJump);
    }

    private String print(String startStation) {
        int startIndex = stations.indexOf(startStation);
        return printStations(startIndex, stations.size() - 1);
    }

    // coclkwise
    private String printStations(int start, int jumps) {
        String toPrint = "";
        for (int i = 0; i <= jumps; i++) {
            int toAdd = (start + i) % stations.size();
            toPrint += stations.get(toAdd) + " ";
        }
        return toPrint.trim();
    }

    private String printStationsCCW(int start, int jumps) {
        String toPrint = "";
        for (int i = 0; i <= jumps; i++) {
            int toAdd = start - i;
            if (toAdd < 0) {
                toAdd += stations.size();
            }
            toPrint += stations.get(toAdd) + " ";
        }
        return toPrint.trim();
    }

    private int minHops(int start, int end) {
        int smallerIndex = Math.min(start, end);
        int biggerIndex = Math.max(start, end);

        int oneWay = biggerIndex - smallerIndex;
        int otherWay = stations.size() - biggerIndex + smallerIndex;

        return Math.min(oneWay, otherWay);
    }

	public static void main(String[] args) {
		Subway newSubwayNetwork = new Subway();
		newSubwayNetwork.run();
	}
}

// class DoublyLinkedList<E> {
    
//     //Data attributes
// 	private ListNode<E> head;
// 	private ListNode<E> tail;
// 	private int size;

// 	public DoublyLinkedList() {
// 		this.head = null;
// 		this.tail = null;
// 		this.size = 0;
// 	}

// 	// returns the size of the linked list
// 	public int size() {
// 		return this.size;
// 	}

// 	// returns true if the list is empty, false otherwise
// 	public boolean isEmpty() {
// 		return this.size == 0;
// 	}

// 	// adds the specified element to the beginning of the list
// 	public void addFirst(E element) {
// 		ListNode<E> newNode = new ListNode<E>(element);

// 		if (size == 0) {
// 			this.head = newNode;
// 			this.tail = this.head;
// 		} else {
// 			ListNode<E> oldHead = this.head;
// 			this.head = newNode;
// 			newNode.setNext(oldHead);
// 			oldHead.setPrev(newNode);
// 		}

// 		this.size++;
// 	}

// 	// retrieves the first element of the list
// 	public E getFirst() throws NoSuchElementException {
// 		if (head == null) {
// 			throw new NoSuchElementException("Cannot get from an empty list");
// 		} else {
// 			return head.getElement();
// 		}
// 	}

// 	// returns true if the list contains the element, false otherwise
// 	public boolean contains(E element) {
// 		for (ListNode<E> current = head; current != null; current = current.getNext()) {
// 			if (current.getElement().equals(element)) {
// 				return true;
// 			}
// 		}

// 		return false;
// 	}

// 	// removes the first element in the list
// 	public E removeFirst() throws NoSuchElementException {
// 		if (head == null) {
// 			throw new NoSuchElementException("Cannot remove from an empty list");
// 		} else {
// 			ListNode<E> currentHead = head;
// 			head = head.getNext();
// 			if (head == null) {
// 				tail = null;
// 			} else {
// 				head.setPrev(null);
// 			}
// 			this.size--;
// 			return currentHead.getElement();
// 		}
// 	}
    
//     // Returns reference to first node.
//     public ListNode<E> getHead() {
//         return this.head;
//     }
    
//     // Returns reference to last node of list.
//     public ListNode<E> getTail() {
//         return this.tail;
//     }

// }

// class ListNode<E> {
// 	private E element;
// 	private ListNode<E> next;
// 	private ListNode<E> prev;

// 	public ListNode(E newElement) {
// 		this.element = newElement;
// 		this.next = null;
// 		this.prev = null;
// 	}

// 	public void setElement(E newElement) {
// 		this.element = newElement;
// 	}

// 	public E getElement() {
// 		return this.element;
// 	}

// 	public void setPrev(ListNode<E> previous) {
// 		this.prev = previous;
// 	}

// 	public void setNext(ListNode<E> next) {
// 		this.next = next;
// 	}

// 	public ListNode<E> getNext() {
// 		return next;
// 	}

// 	public ListNode<E> getPrev() {
// 		return prev;
// 	}
// }
