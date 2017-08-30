package tst;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     TernarySearchTree tst = new TernarySearchTree();
     tst.root = tst.insert(tst.root, "Hello", 0);
     String result = "";
     tst.traverse(tst.root, result);
     tst.insert(tst.root, "HelloJio", 0);
     result = "";
     tst.traverse(tst.root, result);
	}

}
