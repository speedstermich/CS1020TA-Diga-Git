
/**
*	Name		:
*	Matric No.	:
*/

import java.util.*;

public class Browser {
    private final String DEFAULT_PAGE = "http://www.comp.nus.edu.sg";
    private LinkedList<String> tabs;
    private int currentTabIndex;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Browser browser = new Browser();

        for (int i = 0; i < N; i++) {
            String query = sc.next();
            String output;
            if (query.equals("NEWTAB")) {
                output = browser.newTab();
            } else if (query.equals("CLOSETAB")) {
                output = browser.closeTab();
            } else if (query.equals("NEXTTAB")) {
                output = browser.nextTab();
            } else if (query.equals("PREVTAB")) {
                output = browser.prevTab();
            } else if (query.equals("OPENHERE")) {
                String url = sc.next();
                output = browser.openHere(url);
            } else if (query.equals("OPENNEW")) {
                String url = sc.next();
                output = browser.openNew(url);
            } else {
                output = "Invalid input";
            }
            System.out.println(output);
        }
	}

    public Browser() {
        tabs = new LinkedList<>();
        tabs.add(DEFAULT_PAGE);
        currentTabIndex = 0;
    }

    private String newTab() {
        tabs.add(currentTabIndex + 1, DEFAULT_PAGE);
        return getCurrentTab();
    }

    private String closeTab() {
        tabs.remove(currentTabIndex);
        if (currentTabIndex >= tabs.size()) {
            currentTabIndex = tabs.size() - 1;
        }
        return getCurrentTab();
    }

    private String nextTab() {
        currentTabIndex = currentTabIndex + 1 >= tabs.size()
                ? currentTabIndex : currentTabIndex + 1;
        return getCurrentTab();
    }

    private String prevTab() {
        currentTabIndex = currentTabIndex - 1 < 0
                ? currentTabIndex : currentTabIndex - 1;
        return getCurrentTab();
    }

    private String openHere(String url) {
        tabs.set(currentTabIndex, url);
        return getCurrentTab();
    }

    private String openNew(String url) {
        tabs.add(currentTabIndex + 1, url);
        return getCurrentTab();
    }

    private String getCurrentTab() {
        return tabs.get(currentTabIndex);
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
