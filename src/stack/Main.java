package stack;

import java.util.Stack;

public class Main {

	private static boolean matchCharacter(Character x, Character y) {
		if (x == '[' && y == ']')
			return true;
		else if (x == '{' && y == '}')
			return true;
		else if (x == '(' && y == ')')
			return true;
		else
			return false;
	}

	public static boolean parantheseChecker(char[] arr) {
		int size = arr.length;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < size; i++) {
			if (arr[i] == '[' || arr[i] == '{' || arr[i] == '(') {
				stack.push(arr[i]);
			} else if (arr[i] == ']' || arr[i] == '}' || arr[i] == ')') {

				if (stack.isEmpty() == true)
					return false;
				else if (matchCharacter(stack.pop(), arr[i]) == false)
					return false;
			}
		}
		if (stack.isEmpty() == true)
			return true;
		else
			return false;
	}

	private static void nextGreaterElement(int[] arr, int n) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		for (int i = 1; i < n; i++) {
			if (stack.peek() > arr[i])
				stack.push(arr[i]);
			else {
				while (stack.isEmpty() == false && arr[i] > stack.peek()) {
					System.out.println(stack.pop() + " " + arr[i]);
				}
				stack.push(arr[i]);
			}
		}
		while (stack.isEmpty() == false)
			System.out.println(stack.pop() + " " + -1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = "{()}[]".toCharArray();
		if (parantheseChecker(arr) == true)
			System.out.println("Balanced");
		else
			System.out.println("Not Balanced");
		int numarr[] = new int[]{ 13 ,7, 6 ,12 , 25};
		nextGreaterElement(numarr, 5);
		
	}
	

}
