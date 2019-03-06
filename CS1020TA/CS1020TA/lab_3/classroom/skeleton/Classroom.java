
/**
 *	Name		:
 *	Matric No.	:
 */

import java.util.*;

public class Classroom {
    private LinkedList<String> students;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Classroom cr = new Classroom();

        for (int i = 0; i < N; i++) {
            String query = sc.next();
            if (query.equals("enter")) {
                String student1 = sc.next();
                String student2 = sc.next();
                int k = sc.nextInt();
                cr.enter(student1, student2, k);
            } else if (query.equals("leave")) {
                String student = sc.next();
                cr.leave(student);
            } else if (query.equals("list")) {
                System.out.println(cr.list());
            } else {
                System.out.println("Invalid query");
            }
        }
    }

    public Classroom() {
        students = new LinkedList<>();
        students.add("Sharon"); // Sharon is always the first one in the class
    }

    private void enter(String enteringStudent, String referenceStudent, int offset) {
        int index = students.indexOf(referenceStudent);
        int newPos = (index + offset + 1) % (students.size());
        newPos = newPos == 0 ? students.size() : newPos;
        students.add(newPos, enteringStudent);
    }

    private void leave(String studentName) {
        int index = students.indexOf(studentName);
        students.remove(index);
    }

    private String list() {
        StringBuilder sb = new StringBuilder();
        for (String student : students) {
            sb.append(student);
            sb.append(' ');
        }
        // Substring() to trim extra space at the end
        return sb.substring(0, sb.length() - 1).toString();
    }
}

// class LinkedList<E> {
//     protected ListNode head = null;
    
//     public void addAfter(E item, E after) {
        
//     }
    
//     public int findIndex(E item) {
//         return 0;
//     }
// }

// class ListNode<E> {
//     protected E element;
//     protected ListNode<E> next;
    
//     /* constructor */
//     public ListNode(E item) {
//         element = item;
//         next = null;
//     }
    
//     public ListNode(E item, ListNode<E> n) {
//         element = item;
//         next = n;
//     }
    
//     /* get the next ListNode */
//     public ListNode<E> getNext() {
//         return this.next;
//     }
    
//     /* get the element of the ListNode */
//     public E getElement() {
//         return this.element;
//     }
    
//     public void setNext(ListNode<E> item) {
//         this.next = item;
//     }
    
//     public void setElement(E item) {
//         this.element = item;
//     }
// }
