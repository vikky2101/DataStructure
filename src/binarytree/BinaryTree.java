package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	public Node root;

	private int height(Node root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private int diameter(Node root) {
		if (root == null)
			return 0;
		int ld = diameter(root.left);
		int rd = diameter(root.right);
		int lh = height(root.left);
		int rh = height(root.right);
		return Math.max(1 + lh + rh, Math.max(ld, rd));
	}

	// private int maxsumPath(Node root) {
	// if (root == null)
	// return 0;
	// if(root.left == null && root.right == null)
	// return root.getKey();
	// int lsum = maxsumPath(root.left);
	// int rsum = maxsumPath(root.right);
	// int lrsum =
	// return Math.max(1 + lh + rh, Math.max(ld, rd));
	// }

	public int diameterUtil() {
		return diameter(root);
	}

	public int sizeOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
	}

	public void mirror(Node root) {
		if (root == null)
			return;
		mirror(root.left);
		mirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public boolean identicalTree(Node root1, Node root2) {
		if (root1 != null && root2 == null)
			return false;
		else if (root1 == null && root2 != null)
			return false;
		else if (root1 == null && root2 == null)
			return true;
		else {
			return (root1.getKey() == root2.getKey() && identicalTree(root1.left, root2.left)
					&& identicalTree(root1.right, root2.right));
		}
	}

	public void levelOrderTraversal(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.getKey() + " ");
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	public boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 != null)
			return false;
		else if (root1 != null && root2 == null)
			return false;
		else if (root1 == null && root2 == null)
			return true;
		else
			return root1.getKey() == root2.getKey()
					&& ((isIsomorphic(root1.left, root1.left) && isIsomorphic(root1.right, root2.right)
							|| ((isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left)))));
	}

	public void reverse_LevelOrder(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<>();
		Stack<Node> stack = new Stack<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			stack.push(temp);
			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().getKey() + " ");
		}
	}

	public void recursionInorder() {
		if (root == null)
			return;
		Stack<Node> stack = new Stack<Node>();
		Node temp = root;
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}

		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.getKey() + " ");
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}
			}
		}
	}

	public boolean anyleafPathEqualNumber(Node root, int k) {
		if (root == null)
			return false;
		int size = height(root);
		int arr[] = new int[size];
		return anyleafPathEqualNumberUtil(root, arr, 0, root.getKey(), k);
	}

	public boolean anyleafPathEqualNumberUtil(Node root, int[] arr, int index, int csum, int k) {
		if (root == null)
			return false;
		if (k == csum) {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
			return true;
		}
		arr[index++] = root.getKey();
		csum += root.getKey();
		return anyleafPathEqualNumberUtil(root.left, arr, index, csum, k)
				|| anyleafPathEqualNumberUtil(root.right, arr, index, csum, k);
	}

	public boolean checkAllNodeSumOfChildren(Node root) {
		if (root == null || root.left == null && root.right == null)
			return true;
		if (root.left != null && root.right != null)
			return root.getKey() == root.left.getKey() + root.right.getKey() && checkAllNodeSumOfChildren(root.left)
					&& checkAllNodeSumOfChildren(root.right);
		else if (root.left == null)
			return root.getKey() == root.right.getKey() && checkAllNodeSumOfChildren(root.right);
		else
			return root.getKey() == root.left.getKey() && checkAllNodeSumOfChildren(root.left);
	}

	public boolean isBalanced(Node root) {
		if (root == null)
			return true;
		int lh = height(root.left);
		int rh = height(root.right);
		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		else
			return false;
	}

	public boolean isBalancedOptimized(Node root, Height h) {
		if (root == null) {
			h.height = 0;
			return true;
		}
		Height lh = new Height();
		Height rh = new Height();
		boolean l = isBalancedOptimized(root.left, lh);
		boolean r = isBalancedOptimized(root.right, rh);
		h.height = Math.max(lh.height, rh.height) + 1;
		if (Math.abs(lh.height - rh.height) >= 2)
			return false;
		else
			return l && r;
	}

	public boolean isBst(Node root, Node pre) {
		if (root == null)
			return true;
		if (!isBst(root.left, pre))
			return false;
		if (pre != null && pre.getKey() > root.getKey())
			return false;
		pre = root;
		return isBst(root.right, pre);
	}

	public Node lca(Node root, int a, int b, Boolean key1, Boolean key2) {
		if (root == null)
			return null;
		if (root.getKey() == a) {
			key1 = true;
			return root;
		}
		if (root.getKey() == b) {
			key2 = true;
			return root;
		}
		Node lca = lca(root.left, a, b, key1, key2);
		Node rca = lca(root.right, a, b, key1, key2);
		if (lca != null && rca != null)
			return root;
		return lca != null ? lca : rca;
	}

	public void getAllNodesWithoutSibiling(Node root, LinkedList<Node> list) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.left != null && root.right == null)
			list.add(root.left);
		if (root.right != null && root.left == null)
			list.add(root.right);
		getAllNodesWithoutSibiling(root.left, list);
		getAllNodesWithoutSibiling(root.right, list);
	}
}
