package binarytree;

public class Node {
	private int key;
	public Node left, right, next, parent;

	public Node(int data) {
		setKey(data);
		left = right = null;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}


