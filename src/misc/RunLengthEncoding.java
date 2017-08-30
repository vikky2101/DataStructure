package misc;

public class RunLengthEncoding {

	public static void main(String[] args) {
		String str = "wwwwaaadexxxxxx";
		int count ;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {

			count = 1;
			while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}
			sb.append(str.charAt(i));
			sb.append(count);

		}

		System.out.println(sb.toString());

	}
}
