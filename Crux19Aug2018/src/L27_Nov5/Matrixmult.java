package L27_Nov5;

public class Matrixmult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 4, 5 };
		int[][] arr1 = new int[arr.length][arr.length];
		System.out.println(mcm(arr, 0, arr.length - 1));
		System.out.println(mcmTD(arr, 0, arr.length - 1, arr1));
		System.out.println(mcmBU(arr));

	}

	public static int mcm(int[] arr, int si, int ei) {
		int min = Integer.MAX_VALUE;
		if (si + 1 == ei) {
			return 0;
		}
		for (int k = si + 1; k <= ei - 1; k++) {
			int fc = mcm(arr, si, k);
			int sc = mcm(arr, k, ei);
			int sw = arr[si] * arr[ei] * arr[k];
			int total = fc + sc + sw;
			if (total < min) {
				min = total;
			}
		}
		return min;
	}

	public static int mcmTD(int[] arr, int si, int ei, int[][] arr1) {
		int min = Integer.MAX_VALUE;
		if (si + 1 == ei) {
			return 0;
		}
		if (arr1[si][ei] != 0) {
			return arr1[si][ei];
		}
		for (int k = si + 1; k <= ei - 1; k++) {
			int fc = mcm(arr, si, k);
			int sc = mcm(arr, k, ei);
			int sw = arr[si] * arr[ei] * arr[k];
			int total = fc + sc + sw;
			if (total < min) {
				min = total;
				arr1[si][ei] = min;
			}
		}
		return min;
	}

	public static int mcmBU(int[] arr) {
		int n = arr.length;
		int[][] arr2 = new int[n][n];

		for (int slide = 1; slide < n; slide++) {

			for (int si = 0; si <= n - slide - 2; si++) {

				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {
					int fc = arr2[si][k];
					int sc = arr2[k][ei];
					int sw = arr[si] * arr[ei] * arr[k];
					int total = fc + sc + sw;
					if (total < min) {
						min = total;
					}
				}

				arr2[si][ei] = min;

			}

		}
		return arr2[0][n - 1];
	}
}