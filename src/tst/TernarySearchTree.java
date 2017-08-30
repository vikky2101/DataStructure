package tst;

public class TernarySearchTree {

	protected TST root = null;

	public TST insert(TST root, String word, int index) {
		if (root == null) {
			root = new TST(word.charAt(index));
		}
		if (word.charAt(index) < root.key)
			root.left = insert(root.left, word, index);
		else if (word.charAt(index) > root.key)
			root.right = insert(root.right, word, index);
		else {
			if (index + 1 < word.length())
				root.equal = insert(root.equal, word, index+1);
			else
				root.isEnd = true;
		}
		return root;
	}

	public void delete(TST root, String word, int index) {
		if (root == null) {
			return;
		}
		if (word.charAt(index) < root.key)
			delete(root.left, word, index);
		else if (word.charAt(index) > root.key)
			delete(root.right, word, index);
		else {
			if (index + 1 < word.length())
				delete(root.equal, word, index);
			else if (root.isEnd == true && index + 1 == word.length())
				root.isEnd = false;
		}
	}

	public boolean search(TST root, String word, int index) {
		if (root == null) {
			return false;
		}
		if (word.charAt(index) < root.key)
			return search(root.left, word, index);
		else if (word.charAt(index) > root.key)
			return search(root.right, word, index);
		else {
			if (root.isEnd == true && index + 1 == word.length())
				return true;
			else if (index  == word.length() - 1)
				return false;
			else
				return search(root.equal, word, index + 1);

		}
	}
	
	public void traverse(TST root, String result) {
		if (root == null) {
			return ;
		}
		traverse(root.left, result);
		result = result+ root.key;
		if(root.isEnd){
			if(result != null)
			System.out.println(result);
		}
		traverse(root.equal, result);
		traverse(root.right, result);
	}
}
