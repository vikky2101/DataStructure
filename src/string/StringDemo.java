package string;

import java.util.HashMap;

public class StringDemo {

	private static int NonRepeatingLongestSubSeq(String str) {
		if (str == null)
			return 0;
		HashMap<Character, Integer> hashmap = new HashMap<>();
		int max_len = 0, curr_max = 0;
		int pre_Index = 0;
		int i;
		for (i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (hashmap.containsKey(ch))
				pre_Index = hashmap.get(ch);
			else
				pre_Index = -1;

			if (pre_Index == -1 || i - curr_max > pre_Index)
				curr_max++;
			else {
				if (max_len < curr_max)
					max_len = curr_max;
				curr_max = i - pre_Index;
			}
			hashmap.put(ch, i);
		}
		return Math.max(curr_max, max_len);
	}

	private static int minDistance(String str, char a, char b) {
		if (str == null)
			return 0;
		char lastelement = '0';
		int lastIndex = 0;
		int min_so_far = Integer.MAX_VALUE;
		int i = 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) == a || str.charAt(i) == b) {
				lastelement = str.charAt(i);
				lastIndex = i;
				break;
			}
		}
		for (; i < str.length(); i++) {
			if (str.charAt(i) == a || str.charAt(i) == b) {
				if (str.charAt(i) != lastelement && i - lastIndex < min_so_far) {
					min_so_far = i - lastIndex;
					lastelement = str.charAt(i);
				} else {
					lastIndex = i;
				}
			}
		}
		return min_so_far - 1;
	}

	private static int longestPalindromicSubstring(String str) {
		if (str == null || str.isEmpty())
			return 0;
		int maxlength = 1;
		int curr_max = 0;
		int len = str.length();
		for (int i = 1; i < len; i++) {
			int low = i - 1;
			int high = i;
			while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
				low--;
				high++;
				curr_max++;
				maxlength = Math.max(maxlength, curr_max);
			}

		low = i - 1;
		high = i + 1;
		while (low >= 0 && high < len && str.charAt(low) == str.charAt(high)) {
			low--;
			high++;
			curr_max++;
			maxlength = Math.max(maxlength, curr_max);
		}
	}return maxlength;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "vikranvtyucvtvr";
		System.out.println(minDistance(input, 'v', 'r'));

	}

}
