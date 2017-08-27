package testing.interview;

/**
 * A hasCycle function to check is there a Cycle in LinkedList.
 * the LinkedList is a simple edition just has an int data and a Node as next.
 * 
 * @author lishoujun https://github.com/lishoujun/java-learn
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		System.out.println(hasCycle(null));
		System.out.println(hasCycle(new Node(1, null)));
		System.out.println(hasCycle(new Node(1, new Node(1, null))));
		Node first = new Node(1, null);
		first.next = first;
		System.out.println(hasCycle(first));
		Node second = new Node(1, first);
		first.next = second;
		System.out.println(hasCycle(first));
		/**
		 * result:
		 * false 
		 * false 
		 * false 
		 * true 
		 * true
		 */
	}

	public static boolean hasCycle(Node start) {
		if (start == null || start.next == null)
			return false;
		Node tmp = start;
		Node current = start.next;
		while (current.next != null) {
			if (tmp == current) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
}

class Node {
	int data;
	Node next;

	Node() {
	}

	Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}
}
