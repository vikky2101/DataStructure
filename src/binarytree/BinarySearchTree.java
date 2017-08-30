package binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
	public Node root;
	private int matrix[][];

	private int diameter_func2(Node root, Height height) {
		if (root == null) {
			height.height = 0;
			return 0;
		}
		Height lh = new Height();
		Height rh = new Height();
		int ld = diameter_func2(root.left, lh);
		int rd = diameter_func2(root.right, rh);
		height.height = Math.max(lh.height, rh.height) + 1;
		return Math.max(lh.height + rh.height + 1, Math.max(ld, rd));
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

	public void levelOrderSpiralTraversal(Node root) {
		if (root == null)
			return;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		Node temp = null;
		while (true) {
			while (!stack1.isEmpty()) {
				temp = stack1.pop();
				System.out.print(temp.getKey() + " ");
				if (temp.right != null)
					stack2.push(temp.right);
				if (temp.left != null)
					stack2.push(temp.left);
			}
			while (!stack2.isEmpty()) {
				temp = stack2.pop();
				System.out.print(temp.getKey() + " ");
				if (temp.left != null)
					stack1.push(temp.left);
				if (temp.right != null)
					stack1.push(temp.right);
			}
			if (stack1.isEmpty() && stack2.isEmpty())
				return;
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

	public int sizeOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + sizeOfTree(root.left) + sizeOfTree(root.right);
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

	public void mirror(Node root) {
		if (root == null)
			return;
		mirror(root.left);
		mirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	public Node search(Node root, int key) {
		if (root == null || root.getKey() == key)
			return root;
		else if (key < root.getKey())
			return search(root.left, key);
		else
			return search(root.right, key);
	}

	public Node insert(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.getKey())
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}

	public Node delete(Node root, int key) {
		if (root == null)
			return root;
		if (key < root.getKey())
			root.left = delete(root.left, key);
		else if (key > root.getKey())
			root.right = delete(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			Node temp = root.right;
			while (temp.left != null)
				temp = temp.left;
			root.setKey(temp.getKey());
			root.right = delete(root.right, root.getKey());
		}
		return root;
	}

	public Node lca(Node root, int a, int b) {
		if (root == null || root.getKey() == a || root.getKey() == b)
			return root;
		else if (a < root.getKey() && b < root.getKey())
			return lca(root.left, a, b);
		else if (a > root.getKey() && b > root.getKey())
			return lca(root.right, a, b);
		return root;

	}

	public void findPreSucc(Node root, int key, Node pre, Node succ) {
		if (root == null)
			return;
		if (root.getKey() == key) {
			Node temp = root.left;
			if (temp != null) {
				while (temp.right != null)
					temp = temp.right;
				pre = temp;
			}
			Node temp2 = temp.right;
			if (temp2 != null) {
				while (temp2.left != null) {
					temp2 = temp2.left;
				}
				succ = temp2.left;
			}
			return;
		}

		else if (key < root.getKey()) {
			succ = root;
			findPreSucc(root.left, key, pre, succ);
		} else {
			pre = root;
			findPreSucc(root.left, key, pre, succ);
		}
	}

	public Node kSmallest(Node root, int k) {
		if (root == null)
			return null;
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			k--;
			if (k == 0)
				return temp;
			temp = temp.right;
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
		}
		return null;
	}

	public Node kLargest(Node root, int k) {
		if (root == null)
			return null;
		Node temp = root;
		Stack<Node> stack = new Stack<>();
		while (temp != null) {
			stack.push(temp);
			temp = temp.right;
		}
		while (!stack.isEmpty()) {
			temp = stack.pop();
			k--;
			if (k == 0)
				return temp;
			temp = temp.left;
			if (temp != null) {
				stack.push(temp);
				temp = temp.right;
			}
		}
		return null;
	}

	public Node inorderSucc(Node root, Node key) {
		if (root == null)
			return null;
		if (key.right != null) {
			key = key.right;
			while (key.left != null)
				key = key.left;
			return key;
		}
		Node inorder = root;
		while (root != null) {
			if (key.getKey() < root.getKey()) {
				inorder = root;
				root = root.left;
			} else if (key.getKey() > root.getKey()) {
				root = root.right;
			} else
				break;
		}
		return inorder;
	}

	public Node preOrderSucc(Node root, Node key) {
		if (root == null)
			return null;
		if (key.left != null) {
			key = key.left;
			while (key.right != null)
				key = key.right;
			return key;
		}
		Node inorder = null;
		while (root != null) {
			if (key.getKey() < root.getKey()) {
				root = root.left;
			} else if (key.getKey() > root.getKey()) {
				root = root.right;
				inorder = root;
			} else
				break;
		}
		return inorder;
	}

	public Node inorderSucc_Parent(Node key) {
		if (root == null)
			return null;
		if (key.right != null) {
			key = key.right;
			while (key.left != null)
				key = key.left;
			return key;
		}
		Node parent = key.parent;
		while (parent != null && key == parent.right) {
			key = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public Node preOrder_Succ_Parent(Node key) {
		if (root == null)
			return null;
		if (key.left != null) {
			key = key.left;
			while (key.right != null)
				key = key.right;
			return key;
		}
		Node parent = key.parent;
		while (parent != null && key == parent.left) {
			key = parent;
			parent = parent.parent;
		}
		return parent;
	}

	public void printNodesKDistanceRoot(Node root, int k) {
		if (root == null)
			return;
		if (k == 0) {
			System.out.println(root.getKey());
			return;
		}
		printNodesKDistanceRoot(root.left, k - 1);
		printNodesKDistanceRoot(root.right, k - 1);
	}

	public void fixSwappedBST(Node root) {
		if (root == null)
			return;
		Node[] node = new Node[4];
		// Node 3 pre Node 0 first Node 1 middle Node 2 last
		for (int i = 0; i < 3; i++) {
			node[i] = null;
		}
		fixSwappedBSTUtil(root, node);
		if (node[0] != null && node[2] != null) {
			int temp = node[0].getKey();
			node[0].setKey(node[2].getKey());
			node[2].setKey(temp);
		} else if (node[0] != null && node[1] != null) {
			int temp = node[0].getKey();
			node[0].setKey(node[1].getKey());
			node[1].setKey(temp);
		}
	}

	public void fixSwappedBSTUtil(Node root, Node[] node) {
		if (root == null)
			return;
		fixSwappedBSTUtil(root.left, node);
		if (node[3] != null && root.getKey() < node[3].getKey()) {
			if (node[0] == null) {
				node[0] = node[3];
				node[1] = root;
			} else {
				node[2] = root;
			}
		}
		node[3] = root;
		fixSwappedBSTUtil(root.right, node);
	}

	public Node trimBST(Node root, int min, int max) {
		if (root == null)
			return null;
		root.left = trimBST(root.left, min, max);
		root.right = trimBST(root.right, min, max);
		if (root.getKey() < min) {
			Node temp = root.right;
			root = null;
			return temp;
		} else if (root.getKey() > max) {
			Node temp = root.left;
			root = null;
			return temp;
		} else
			return root;
	}

	public void connect(Node root) {
		if (root == null)
			return;
		root.next = null;
		connectUtil(root);
	}

	private void connectUtil(Node root) {
		Node temp = root;
		while (root != null) {
			temp = root;
			while (temp != null) {
				if (temp.left != null) {
					if (temp.right != null) {
						temp.left.next = temp.right;
					} else {

						temp.left.next = getNextRight(temp);
					}
				}
				if (temp.right != null) {
					temp.right.next = getNextRight(temp);
				}

				temp = temp.next;
			}
			if (root.left != null)
				root = root.left;
			else if (root.right != null)
				root = root.right;
			else
				root = getNextRight(root);
		}
	}

	private Node getNextRight(Node root) {
		Node temp = root.next;
		while (temp != null) {
			if (temp.left != null)
				return temp.left;
			if (temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return temp;
	}

	public int ancestorMatrix(Node root, LinkedList<Integer> ancsetors) {
		if (root == null)
			return 0;
		int data = root.getKey();
		for (int i = 0; i < ancsetors.size(); i++) {
			matrix[ancsetors.get(i)][data] = 1;
		}
		ancsetors.add(data);
		int l = ancestorMatrix(root.left, ancsetors);
		int r = ancestorMatrix(root.right, ancsetors);
		ancsetors.removeLast();
		return l + r + 1;

	}

	public void boundaryTraversal(Node root) {
		if (root == null)
			return;
		System.out.print(root.getKey() + " ");
		printBoundaryleft(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printBoundaryRight(root.right);
	}

	public void printBoundaryleft(Node root) {
		if (root != null) {
			if (root.left != null) {
				System.out.print(root + " ");
				printBoundaryleft(root.left);
			} else if (root.right != null) {
				System.out.print(root + " ");
				printBoundaryleft(root.right);
			}
		}
	}

	public void printBoundaryRight(Node root) {
		if (root != null) {
			if (root.right != null) {
				printBoundaryRight(root.right);
				System.out.print(root + " ");
			} else if (root.left != null) {
				printBoundaryRight(root.left);
				System.out.print(root + " ");
			}
		}
	}

	private void printLeaves(Node root) {
		if (root == null)
			return;
		printLeaves(root.left);
		if (root.left == null && root.right == null) {
			System.out.print(root.getKey() + " ");
			return;
		}

		printLeaves(root.right);
	}

	private void verticalSum(Node root, int d, HashMap<Integer, Integer> map) {
		if (root == null)
			return;
		map.put(d, root.getKey());
		verticalSum(root.left, d - 1, map);
		verticalSum(root.right, d + 1, map);
	}

	public void verticalSumUtil(Node root) {
		if (root == null)
			return;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		verticalSum(root, 0, hashMap);
		if (hashMap != null)
			System.out.println(hashMap.entrySet());
	}

	public void convertDLL(Node root, Node pre, Node head) {
		if (root == null)
			return;
		convertDLL(root.left, pre, head);
		if (pre == null) {
			head = root;
		} else {
			root.left = pre;
			pre.right = root;
		}
		pre = root;
		convertDLL(root.right, pre, head);

	}

	public void convertDLL2(Node root, Node pre) {
		if (root == null)
			return;
		convertDLL2(root.right, pre);
		if (pre != null) {
			root.right = pre;
			pre.left = root;
		}
		pre = root;
		convertDLL2(root.left, pre);

	}

	public boolean checkBST(Node root, Node pre) {
		if (root == null)
			return true;
		if (!checkBST(root.left, pre))
			return false;
		if (pre != null && root.getKey() < pre.getKey())
			return false;
		pre = root;
		return checkBST(root.right, pre);
	}

	private boolean checkLeavesSameLevel(Node root, Integer obj, int level) {
		if (root == null)
			return true;
		if (root.left == null && root.right == null) {
			if (obj == null) {
				obj = level;
				return true;
			} else
				return obj.intValue() == level;
		}
		return checkLeavesSameLevel(root.left, obj, level + 1) && checkLeavesSameLevel(root.right, obj, level + 1);
	}

	private void findPair_SumK(Node root, int sum) {
		if (root == null)
			return;
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		Node temp1 = root, temp2 = root;
		boolean flag1 = false, flag2 = false;
		int key1 = -1, key2 = -1;
		while (true) {
			while (flag1 == false) {
				if (temp1 != null) {
					stack1.push(temp1);
					temp1 = temp1.left;
				} else {
					if (stack1.isEmpty()) {
						flag1 = true;
					} else {
						key1 = stack1.pop().getKey();
						flag1 = true;
						temp1 = temp1.right;
					}
				}
			}
			while (flag2 == false) {
				if (temp2 != null) {
					stack2.push(temp2);
					temp2 = temp2.right;
				} else {
					if (stack2.isEmpty()) {
						flag2 = true;
					} else {
						key2 = stack2.pop().getKey();
						flag2 = true;
						temp1 = temp1.left;
					}
				}
			}

			if (key1 != key2 && key1 + key2 == sum) {
				System.out.println("Nodes are" + key1 + key2);
			} else if (key1 + key2 < sum)
				flag1 = false;
			else
				flag2 = false;

			if (key1 > key2) {
				System.out.println("Node Pair not found");
				return;
			}
		}

	}

	public Node prune(Node root, int sum) {
		if (root == null || sum <= 0)
			return root;
		root.left = prune(root.left, sum - root.getKey());
		root.right = prune(root.right, sum - root.getKey());
		if (root.left == null && root.right == null && sum > root.getKey()) {
			root = null;
			return null;
		}
		return root;
	}

	public void nearestElement(Node root, int key, Integer minKey, Integer min_diff) {
		if (root == null)
			return;
		if (root.getKey() - key == 0) {
			System.out.println("Closest ele" + root.getKey());
			return;
		}
		if (min_diff > Math.abs(root.getKey() - key)) {
			min_diff = Math.abs(root.getKey() - key);
			minKey = root.getKey();
		}
		if (key < root.getKey())
			nearestElement(root.left, key, minKey, min_diff);
		else
			nearestElement(root.right, key, minKey, min_diff);

	}

	public void connectLeavesDLL(Node root, Node pre, Node next) {
		if (root == null)
			return;
		connectLeavesDLL(root.left, pre, next);
		if (root.left == null && root.right == null) {
			if (pre == null) {
				pre = root;
			} else {
				pre.right = root;
				root.left = pre;
				pre = root;
			}
		}
		connectLeavesDLL(root.right, pre, next);
	}

	public Node find(Node root, int key) {
		if (root == null)
			return null;
		if (key < root.getKey())
			return find(root.left, key);
		else if (key > root.getKey())
			return find(root.right, key);
		else
			return root;

	}

	public int closetLeaf(Node root, int key) {
		Node temp = find(root, key);
		if (temp == null) {
			System.out.println("key not exists");
			return 0;
		}
		Integer min = new Integer(Integer.MAX_VALUE);
		closeestLeafUtil(root, temp, min, 0);
		return min;
	}

	private void closeestLeafUtil(Node root, Node temp, Integer min, int dis) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			if (dis < min)
				min = dis;
			return;
		}
		closeestLeafUtil(root.left, temp, min, dis + 1);
		closeestLeafUtil(root.right, temp, min, dis + 1);

	}

	private Node constructBST(int inorder[], int preorder[], int start, int end, int preIndex) {
		if (start > end)
			return null;
		Node root = new Node(preorder[start]);
		if (start == end) {
			return root;
		}
		int i = start;
		while (i <= end && inorder[i] != preorder[preIndex++])
			i++;
		root.left = constructBST(inorder, preorder, start, i, preIndex);
		root.right = constructBST(inorder, preorder, i + 1, end, preIndex);
		return root;
	}

	private Node constructBST2(int inorder[], int postrder[], int start, int end, int postIndex) {
		if (start > end)
			return null;
		Node root = new Node(postrder[postIndex]);
		if (start == end) {
			return root;
		}
		int i = start;
		while (i <= end && inorder[i] != postrder[postIndex--])
			i++;
		root.left = constructBST(inorder, postrder, start, i, postIndex);
		root.right = constructBST(inorder, postrder, i + 1, end, postIndex);
		return root;
	}

	private Node constructBSTFromSortedArray(int arr[], int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node root = new Node(arr[mid]);
		if (start == end) {
			return root;
		}
		root.left = constructBSTFromSortedArray(arr, start, mid - 1);
		root.right = constructBSTFromSortedArray(arr, mid + 1, end);
		return root;
	}

	private void replaceGreaterValues(Node root, Integer sum) {
		if (root == null)
			return;
		replaceGreaterValues(root.right, sum);
		sum += root.getKey();
		root.setKey(sum);
		replaceGreaterValues(root.left, sum);
	}

	private int ceil(Node root, int key, Integer ceil) {
		if (root == null)
			return 0;
		if (root.getKey() == key)
			return key;
		else if (root.getKey() < key) {
			return ceil(root.right, key, ceil);
		} else {
			ceil = ceil(root.left, key, ceil);
			return ceil >= key ? ceil : root.getKey();
		}
	}

	private int floor(Node root, int key, Integer floor) {
		if (root == null)
			return 0;
		if (root.getKey() == key)
			return key;
		else if (root.getKey() > key) {
			return floor(root.left, key, floor);
		} else {
			floor = floor(root.right, key, floor);
			return floor <= key ? floor : root.getKey();
		}
	}

	}