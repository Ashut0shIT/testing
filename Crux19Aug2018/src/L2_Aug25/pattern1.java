package L2_Aug25;

import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row=1;
		int nst=n;
		while(row<=n) {
			int col=1;
			while(col<=nst) {
				System.out.print("*");
				col=col+1;
			}
			
			System.out.println();
			nst=nst-1;
			row=row+1;
		}

	}

}
