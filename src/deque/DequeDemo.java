package deque;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

	public static void main(String[] args) {
		int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
		printMaxKWindow(arr, arr.length, 3);
	}

	private static void printMaxKWindow(int[] arr, int length, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int i = 0;
		for (; i < k; i++) {
			if (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		for (; i < length; i++) {
			System.out.println(deque.peek());
			while (!deque.isEmpty() && deque.peek() <= i - k) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.println(arr[deque.peek()]);
	}

	private static void printMinKWindow(int[] arr, int length, int k) {
		Deque<Integer> deque = new LinkedList<>();
		int i = 0;
		for (; i < k; i++) {
			if (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}

		for (; i < length; i++) {
			System.out.println(deque.peek());
			while (!deque.isEmpty() && deque.peek() <= i - k) {
				deque.removeFirst();
			}

			while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
				deque.removeLast();
			}
			deque.addLast(i);

		}
		System.out.println(arr[deque.peek()]);
	}
}
