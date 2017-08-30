package matrix;

public class PrintMatrixDiagonalForm {

	private int MAX = 3;

	private static int binarySearch(int arr[], int low, int high, int num) {
		if (low > high)
			return -1;
		int mid = low + (high - low) / 2;
		while (low < high) {
			if (mid == 0 || arr[mid] == num && arr[mid - 1] == 0)
				return mid;
			else if (arr[mid] < num)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	private static int findMaxOneRow(int mat[][], int m, int n) {
		int row_index = -1;
		int col_index = -1;
		while (col_index != -1 && row_index < n) {
			col_index = binarySearch(mat[row_index], 0, n - 1, 1);
		}

		if (row_index == n && col_index == -1) {
			System.out.println("-1 is not available in matrix");
		}
		int row = row_index;
		int col = col_index;
		while (++row < n) {
			if (mat[row][col_index] == 1)
				col_index = binarySearch(mat[row], 0, col, 1);
			if (col_index < col)
				row_index = row;
		}
		return row_index;
	}

	public static void leftrotateInplace(int mat[][], int m, int n) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][n - i - 1];
				mat[j][n - i - 1] = mat[n - i - 1][n - j - 1];
				mat[n - i - 1][n - j - 1] = mat[n - j - 1][i];
				mat[n - j - 1][i] = temp;
			}
		}
	}

	public static void rightrotateInplace(int mat[][], int m, int n) {
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[n - j - 1][i];
				mat[n - j - 1][i] = mat[n - i - 1][n - j - 1];
				mat[n - i - 1][n - j - 1] = mat[j][n - i - 1];
				mat[j][n - i - 1] = temp;
			}
		}
	}

	private static boolean isCrossMatrix(int mat[][], int m, int n) {
		int diag = mat[0][0];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == diag && i != j) {
					return false;
				} else if (mat[i][j] != diag && i == j)
					return false;
			}
		}
		return true;
	}

	private static void findKey_SortedRow_Col(int mat[][], int m, int n, int key) {
		int i = 0;
		int j = n - 1;
		while (i < m && j >= 0) {
			if (mat[i][j] == key) {
				System.out.println("Found key X:" + i + "Y" + j);
				return;

			} else if (key < mat[i][j])
				j--;
			else if (key > mat[i][j])
				i++;
		}
		if (i > m || j < 0)
			System.out.println("Ele not found");
	}

	private static void print_Spiral(int mat[][], int m, int n) {
		int frow = 0, fcol = 0, lrow = m - 1, lcol = n - 1;
		while (frow < lrow && fcol < lcol) {
			for (int j = fcol; j <= lcol; j++)
				System.out.println(mat[frow][j]);
			frow++;
			for (int j = frow; j <= lrow; j++)
				System.out.println(mat[j][lcol]);
			lcol--;
			if (frow < lrow) {
				for (int j = lcol; j >= fcol; j--)
					System.out.println(mat[lrow][j]);
				lrow--;
			}
			if (fcol < lcol) {
				for (int j = lrow; j >= frow; j--)
					System.out.println(mat[j][fcol]);
				fcol++;
			}
		}
	}

	private static void printMatrix(int matrxi[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrxi[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// System.out.println(findMaxOneRow(mat, 3, 3));
		printMatrix(mat, 3, 3);
		System.out.println("");
		rightrotateInplace(mat, 3, 3);
		printMatrix(mat, 3, 3);
		System.out.println("");
		leftrotateInplace(mat, 3, 3);
		printMatrix(mat, 3, 3);
	}
}
