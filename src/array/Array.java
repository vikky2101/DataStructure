package array;

import java.util.HashMap;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 15, 18, 2, 3, 6, 12 };
		System.out.println(count_rotation(arr, arr.length));

		int temp[] = { 4, 6, 8, 3, 6 };
		sumAfterNIteration(temp, temp.length, 3);
		System.out.println();

		System.out.println("Secondmax : " + secondMax(arr, arr.length));
		int temp1[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };

		int key = 6;
		System.out.println("Rotatd element at index : " + search_K_Rotated_Array(temp1, 0, temp1.length, key));

		int temp2[] = { 3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3 };
		int x = 3;
		int y = 6;
		System.out
				.println("Minimum distance b/w " + x + " " + y + " is " + minimum_distance(temp2, temp2.length, x, y));

		int temp3[] = { 2, 0, 1, 1, 2, 0, 1 };
		sort_0_1_2(temp3, temp3.length);
		for (int i = 0; i < temp3.length; i++)
			System.out.print(temp3[i] + " ");
		System.out.println();

		int leftRotatearr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.print("Before rotation ");
		for (int i = 0; i < leftRotatearr.length; i++)
			System.out.print(leftRotatearr[i] + " ");
		System.out.println();
		leftrotate_k(leftRotatearr, leftRotatearr.length, 2);
		System.out.print("After rotation ");
		for (int i = 0; i < leftRotatearr.length; i++)
			System.out.print(leftRotatearr[i] + " ");
		System.out.println();

	}

	private static int count_rotation(int arr[], int n) {
		int low = 0, high = n;
		while (low < high) {
			int mid = (low + high) / 2;
			if (mid < high && arr[mid + 1] < arr[mid])
				return mid + 1;
			if (low < mid && arr[mid] < arr[mid - 1])
				return mid;
			if (arr[low] < arr[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private static void sumAfterNIteration(int arr[], int n, int k) {
		int sum = 0;
		int i = 0, count = n - 1;
		while (k-- >= 0) {
			i = 0;
			sum = arr[i];
			while (i < count) {
				sum += arr[i + 1];
				arr[i] = arr[i] - arr[i + 1];
				i++;
			}
			count = count - 1;
			System.out.print(sum + " ");
		}
	}

	private static int secondMax(int arr[], int n) {
		int fmax, smax;
		if (arr.length < 2) {
			System.out.println("Second largest not possible");
			return Integer.MIN_VALUE;
		}
		fmax = Math.max(arr[0], arr[1]);
		smax = Math.min(arr[0], arr[1]);
		for (int i = 3; i < n; i++) {
			if (arr[i] > fmax) {
				smax = fmax;
				fmax = arr[i];
			} else if (arr[i] < fmax && arr[i] > smax) {
				smax = arr[i];
			}
		}
		return smax;
	}

	private static int search_K_Rotated_Array(int arr[], int l, int n, int num) {
		if (l > n)
			return -1;
		int mid = (l + n) / 2;
		if (arr[mid] == num)
			return mid;
		if (arr[l] <= arr[mid]) {
			if (num >= arr[l] && num <= arr[mid])
				return search_K_Rotated_Array(arr, l, mid - 1, num);
			else
				return search_K_Rotated_Array(arr, mid + 1, n, num);
		}
		if (num >= arr[mid] && num <= arr[n])
			return search_K_Rotated_Array(arr, mid + 1, n, num);
		else
			return search_K_Rotated_Array(arr, l, mid - 1, num);
	}

	private static int minimum_distance(int arr[], int n, int x, int y) {
		int min = Integer.MAX_VALUE, lastIndex = -1;
		int i = 0;
		for (; i < n; i++) {
			if (arr[i] == x || arr[i] == y) {
				lastIndex = i;
				break;
			}
		}
		for (; i < n; i++) {
			if (arr[i] == x || arr[i] == y) {
				if (arr[i] != arr[lastIndex] && i - lastIndex < min) {
					min = i - lastIndex;
				} else if (arr[i] == arr[lastIndex])
					lastIndex = i;
			}
		}
		return min;
	}

	private static void sort_0_1_2(int arr[], int n) {
		int low = 0, mid = 0, high = n - 1;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, high, mid);
				high--;
				break;
			}
		}
	}

	private static void swap(int arr[], int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	private static void leftrotate_k(int arr[], int n, int d) {
		int gcd = gcd(n, d);
		for (int i = 0; i < gcd; i++) {
			int temp = arr[i];
			int j = i;
			while (true) {
				int k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
	}

	private static int max_Subarray_K_Unique(int arr[], int n, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int s_index = 0;
		int max_len = -1;
		hashMap.put(arr[0], 1);
		for (int i = 1; i < n; i++) {
			if (hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i] + 1));
			} else {
				while (hashMap.size() == k) {
					int count = hashMap.get(arr[s_index]);
					count--;
					if (count == 0)
						hashMap.remove(arr[s_index]);
					else
						hashMap.put(arr[s_index], count);
					s_index++;
				}
				hashMap.put(arr[i], 1);
			}

			if (i - s_index > max_len)
				max_len = i - s_index;

		}

		return max_len;
	}

}
