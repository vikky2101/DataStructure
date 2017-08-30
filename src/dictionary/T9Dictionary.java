package dictionary;

import java.util.HashMap;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

public class T9Dictionary {

	static HashMap<Integer, String> hashTable = new HashMap<>();

	public static void main(String args[]) {
		int number[] = { 2, 3, 4 };
		printWords(number, number.length);
	}

	private static void printWords(int[] number, int length) {
		hashTable.put(0, "");
		hashTable.put(1, " ");
		hashTable.put(2, "abc");
		hashTable.put(3, "def");
		hashTable.put(4, "ghi");
		hashTable.put(5, "jkl");
		hashTable.put(6, "mno");
		hashTable.put(7, "pqrs");
		hashTable.put(8, "tuv");
		hashTable.put(9, "wxyz");
		char[] output = new char[length + 1];
		output[length] = '\0';
		printWordsUtil(number, 0, length, output);
	}

	private static void printWordsUtil(int[] number, int i, int length, char[] output) {
		if (i == length) {
			System.out.println(output);
			return;
		}
		for (int k = 0; k < hashTable.get(number[i]).length(); k++) {
			output[i] = hashTable.get(number[i]).toCharArray()[k];
			printWordsUtil(number, i + 1, length, output);
			if (number[i] == 0 || number[i] == 1)
				return;
		}
	}
}
