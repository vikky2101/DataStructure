package linkedlist;

public class MyLinkedList<T> {

	private LinkedListNode<T> head = null;

	public LinkedListNode<T> inserFront(LinkedListNode<T> node) {
		node.setNext(head);
		head = node;
		return head;
	}

	public LinkedListNode<T> insertEnd(LinkedListNode<T> node) {
		if (head == null) {
			head = node;
		} else {
			LinkedListNode<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}

		return head;
	}

	public LinkedListNode<T> delete(T value) {
		if (head == null)
			return null;
		LinkedListNode<T> temp = head;
		if (head.getKey() == value) {
			temp = head;
			head = head.getNext();
			temp = null;
			return head;
		}
		temp = head;
		LinkedListNode<T> pre = temp;
		while (temp != null && temp.getKey() != value) {
			pre = temp;
			temp = temp.getNext();
		}
		pre.setNext(temp.getNext());
		temp = null;
		return head;
	}

	public void printLinkedList() {
		while (head != null) {
			System.out.print(head.getKey() + " ");
			head = head.getNext();
		}
	}

	public LinkedListNode<T> reverse_k(LinkedListNode<T> head, int k) {
		if (head == null)
			return null;
		LinkedListNode<T> pre = null, next = null, temp = null;
		temp = head;
		int i = 0;
		while (i++ < k && temp != null) {
			next = temp.getNext();
			temp.setNext(pre);
			pre = temp;
			temp = next;
		}
		if (temp != null)
			head.setNext(reverse_k(temp, k));
		return pre;
	}

	public LinkedListNode<T> cloneRandomLinkedList(LinkedListNode<T> head) {
		if (head == null)
			return null;
		LinkedListNode<T> temp = head, next = null, head2 = null;
		while (temp != null) {
			LinkedListNode<T> newNode = new LinkedListNode<T>(temp.getKey());
			next = temp.getNext();
			temp.setNext(newNode);
			newNode.setNext(next);
			temp = next;
		}

		while (temp != null) {
			temp.getNext().setRandom(temp.getRandom().getNext());
			temp = temp.getNext().getNext();
		}
		temp = head;
		head2 = null;
		next = null;
		while (temp != null) {
			temp.setNext(temp.getNext().getNext());
			if (head2 == null) {
				head2 = temp.getNext();
				next = head2;
			} else {
				next.setNext(temp.getNext());
				next = next.getNext();
			}
			next.setNext(null);
			temp = temp.getNext();
		}
		return head2;
	}

	public LinkedListNode<T> reverse_k_m(LinkedListNode<T> head, int k, int m) {
		if (head == null)
			return null;
		LinkedListNode<T> temp = head, next = head.getNext(), pre = null, shead = null, newfhead, newshead;
		while (k > 0 && temp != null) {
			next = temp.getNext();
			temp.setNext(pre);
			pre = temp;
			temp = next;
			k--;
		}
		newfhead = pre;
		pre = null;
		shead = temp;
		while (m > 0 && temp != null) {
			next = head.getNext();
			head.setNext(pre);
			pre = head;
			temp = next;
			k--;
		}
		newshead = pre;
		head.setNext(newshead);
		if (temp != null)
			shead.setNext(reverse_k_m(temp, k, m));
		return newfhead;
	}

	public LinkedListNode<T> getKNodeEnd(LinkedListNode<T> head, int k) {
		if (head == null)
			return null;
		LinkedListNode<T> slow = head, next = head;
		while (k-- > 0)
			next = next.getNext();
		while (next != null) {
			slow = slow.getNext();
			next = next.getNext();
		}
		return slow;
	}

	public boolean isPalindrome(LinkedListNode<T> head) {
		if (head == null)
			return true;
		LinkedListNode<T> tail = head;
		return isPalindromeUtil(head, tail);
	}

	private boolean isPalindromeUtil(LinkedListNode<T> head, LinkedListNode<T> tail) {
		if (tail == null)
			return true;

		boolean isPal = isPalindromeUtil(head, tail.getNext());
		if (isPal && head.getKey() == tail.getKey()) {
			head = head.getNext();
			return true;
		} else {
			head = head.getNext();
			return false;

		}
	}

	private LinkedListNode<T> swapAlternateNodes(LinkedListNode<T> head) {
		if (head == null || head.getNext() == null)
			return head;
		LinkedListNode<T> temp = head, next = null, nnext = null;
		while (temp != null && temp.getNext() != null) {
			next = temp.getNext();
			nnext = next.getNext();
			next.setNext(temp);
			if (nnext != null && nnext.getNext() != null)
				temp.setNext(nnext.getNext());
			else
				temp.setNext(nnext);
			temp = nnext;
		}
		return head.getNext();
	}

	private LinkedListNode<T> sortedMerge(LinkedListNode<T> head1, LinkedListNode<T> head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		LinkedListNode<T> result = null;
		if ((int) head1.getKey() <= (int) head2.getKey()) {
			result = head1;
			head1.setNext(sortedMerge(head1.getNext(), head2));
		} else {
			result = head1;
			head1.setNext(sortedMerge(head1.getNext(), head2));
		}
		return result;
	}

	public LinkedListNode<T> sort_0_1_2(MyLinkedList<T> list) {
		LinkedListNode<T> head = list.head;
		if (head == null)
			return null;
		System.out.println("hello");
		return null;
		// /*LinkedListNode<T> newhead = null, zero_end = null,
		// one_start = null, one_end = null,
		// two_start =null, two_end = null;
		// while(head != null){
		// System.out.println("hello");
		// if((int)head.getKey() == 0){
		//
		// if(newhead == null){
		// newhead = head;
		// zero_end = head;
		// }
		// else{
		// zero_end.setNext(head);
		// zero_end = head;
		// }
		// }
		// else if((int)head.getKey() == 1){
		// if(one_start == null){
		// one_start = head;
		// one_end = head;
		// }
		// else{
		// one_end.setNext(head);
		// one_end = head;
		// }
		// }
		// else if((int)head.getKey() == 2){
		// if(two_start == null){
		// two_start = head;
		// two_end = head;
		// }
		// else{
		// two_end.setNext(head);
		// two_end = head;
		// }
		// }
		// head = head.getNext();
		// }
		// System.out.println("hello");
		// System.out.println(zero_end.getKey());
		// System.out.println(one_start.getKey());
		// System.out.println(two_start.getKey());
		// zero_end.setNext(one_start);
		// one_end.setNext(two_start);
		// two_end.setNext(null);
		// return newhead;*/
	}
}
