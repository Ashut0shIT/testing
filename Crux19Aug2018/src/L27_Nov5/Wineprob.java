package L27_Nov5;

public class Wineprob {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 2, 3, 5, 1, 4 };
		int[][] arr = new int[price.length][price.length];
		System.out.println(wineprob(price, 0, price.length - 1, 1));
		System.out.println(wineprob2(price, 0, price.length - 1));
		System.out.println(wineprobTD(price, 0, price.length - 1, arr));
		System.out.println(wineprobBU(price));
	}

	public static int wineprob(int[] price, int si, int ei, int yr) {
		if (si > ei) {
			return 0;
		}
		int sc = wineprob(price, si + 1, ei, yr + 1) + (price[si] * yr);
		int ec = wineprob(price, si, ei - 1, yr + 1) + (price[ei] * yr);

		return Math.max(sc, ec);
	}

	public static int wineprob2(int[] price, int si, int ei) {
		if (si > ei) {
			return 0;
		}
		int yr = price.length - (ei - si);
		int sc = wineprob2(price, si + 1, ei) + (price[si] * yr);
		int ec = wineprob2(price, si, ei - 1) + (price[ei] * yr);

		return Math.max(sc, ec);
	}

	public static int wineprobTD(int[] price, int si, int ei, int[][] arr) {
		if (si > ei) {
			return 0;
		}
		if (arr[si][ei] != 0) {
			return arr[si][ei];
		}
		int ans = 0;
		int yr = price.length - (ei - si);
		int sc = wineprobTD(price, si + 1, ei, arr) + (price[si] * yr);
		int ec = wineprobTD(price, si, ei - 1, arr) + (price[ei] * yr);

		ans = Math.max(sc, ec);
		arr[si][ei] = ans;
		return ans;
	}

	public static int wineprobBU(int[] price) {
		int n = price.length;
		int[][] arr = new int[n][n];
		int ans = 0;
		for (int slide = 0; slide < n; slide++) {
			for (int si = 0; si <= n - slide - 1; si++) {
				int ei = si + slide;

				int yr = price.length - (ei - si);
				if (si == ei) {
					arr[si][ei] = price[si] * yr;
				} else {
					int sc = arr[si + 1][ei] + price[si] * yr;
					int ec = arr[si][ei - 1] + price[ei] * yr;
					ans = Math.max(sc, ec);
					arr[si][ei] = ans;
				}

			}
		}
		return arr[0][n - 1];
	}

}
