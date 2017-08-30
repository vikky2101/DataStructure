package binarytree;

import binarytree.*;

public class Main {
	static long[] fib = new long[1000];
	
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The diameter of given binary tree is : " + tree.diameterUtil());

		System.out.println("Level order traversal of binary tree is - ");
		tree.levelOrderTraversal(tree.root);
		
		System.out.println();
		System.out.println("Reverse Level order traversal of binary tree is - ");
		tree.reverse_LevelOrder(tree.root);
		
		System.out.println();
		System.out.println("Inorder order traversal of binary tree is - ");
		tree.recursionInorder();
		System.out.println("Size of binary tree is -" + tree.sizeOfTree(tree.root));
		if (tree.identicalTree(tree.root, tree.root))
			System.out.println("Tree are identical");
		else
			System.out.println("Tree are not identical");

		// /* Let us create following BST
		// 50
		// / \
		// 30 70
		// / \ / \
		// 20 40 60 80 */
		BinarySearchTree bst = new BinarySearchTree();
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 80);
		
		System.out.println("Spriral Level order traversal of binary tree is - ");
		bst.levelOrderSpiralTraversal(bst.root);
		
		int a = 20, b = 40;
		Node t = bst.lca(bst.root, a, b);
		System.out.println("LCA of " + a + " and " + b + " is " + t.getKey());
		Node pre = new Node(0), succ = new Node(0);
		bst.findPreSucc(bst.root, 30, pre, succ);
		System.out.println("Pre and Succ of 30 are :" + pre.getKey() + " " + succ.getKey());
		Node ksmallest = bst.kSmallest(bst.root, 3);
		if (ksmallest != null)
			System.out.println("Ksmallest node  :" + ksmallest.getKey());
		else
			System.out.println("Ksmallest node doesn't exist :");
		int key = 16;
		Integer nearest = Integer.MAX_VALUE; 
		Integer min_key = -1;
		bst.nearestElement(bst.root, key, min_key, nearest);

	}

	
	
	
}
