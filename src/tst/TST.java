package tst;

public class TST {
	protected char key;
	protected TST left, right, equal;
	public TST getEqual() {
		return equal;
	}

	public void setEqual(TST equal) {
		this.equal = equal;
	}

	boolean isEnd;

	public TST(char key) {
		this.key = key;
		this.left = null;
		this.right = null;
		this.isEnd = false;
	}

}
