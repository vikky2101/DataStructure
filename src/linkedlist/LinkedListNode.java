package linkedlist;

public class LinkedListNode<T> {
	private T key;
	private LinkedListNode<T> next;
	private LinkedListNode<T> random;;

	public LinkedListNode(T data) {
		this.key = data;
		next = null;
	}

	public T getKey() {
		return this.key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public LinkedListNode<T> getNext() {
		return this.next;
	}

	public void setNext(LinkedListNode<T> next) {
		this.next = next;
	}

	public LinkedListNode<T> getRandom() {
		return random;
	}

	public void setRandom(LinkedListNode<T> random) {
		this.random = random;
	}
}
