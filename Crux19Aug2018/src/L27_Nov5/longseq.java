package L27_Nov5;

public class longseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sunday";
		String s2 = "saturday";
		int[][] arr = new int[s1.length()][s2.length()];
		System.out.println(LCS(s1, s2));
		System.out.println(LCSBU(s1, s2));
		System.out.println(EditDistance(s1, s2));
		System.out.println(EditdistanceBU(s1, s2));
		System.out.println(EditdistanceTD(s1, s2, arr));

	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			ans = Math.max(LCS(ros1, s2), LCS(s1, ros2));
		}
		return ans;
	}

	public static int LCSBU(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if (s1.charAt(row) == s2.charAt(col)) {
					arr[row][col] = arr[row + 1][col + 1] + 1;
				} else {
					arr[row][col] = Math.max(arr[row][col + 1], arr[row + 1][col]);
				}
			}
		}
		return arr[0][0];

	}

	public static int EditDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int insert = EditDistance(ros1, s2);
			int delete = EditDistance(s1, ros2);
			int replace = EditDistance(ros1, ros2);
			ans = Math.min(replace, Math.min(delete, insert)) + 1;
		}
		return ans;

	}

	public static int EditdistanceBU(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					arr[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					arr[row][col] = s1.length() - row;
					continue;
				}
				if (s1.charAt(row) == s2.charAt(col)) {
					arr[row][col] = arr[row + 1][col + 1];
				} else {
					int insert = arr[row + 1][col];
					int delete = arr[row][col + 1];
					int replace = arr[row + 1][col + 1];
					arr[row][col] = Math.min(replace, Math.min(delete, insert)) + 1;
				}
			}
		}
		return arr[0][0];

	}

	public static int EditdistanceTD(String s1, String s2, int[][] arr) {
		int[][] arr1 = new int[s1.length() + 1][s2.length() + 1];
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		if (arr1[s1.length()][s2.length()] != 0) {
			return arr[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans = 0;
		if (ch1 == ch2) {
			ans = EditDistance(ros1, ros2);
		} else {
			int insert = EditdistanceTD(ros1, s2, arr1);
			int delete = EditdistanceTD(s1, ros2, arr1);
			int replace = EditdistanceTD(ros1, ros2, arr1);
			ans = Math.min(replace, Math.min(delete, insert)) + 1;
			arr1[s1.length()][s2.length()] = ans;
		}
		return ans;
	}

}
