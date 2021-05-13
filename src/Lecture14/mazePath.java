package Lecture14;

import java.util.ArrayList;
import java.util.Scanner;

public class mazePath {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int er = scn.nextInt();
		int ec = scn.nextInt();
		System.out.print(maze(0,0,er,ec));
	}

	public static ArrayList<String> maze(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		
		if(cr>er || cc> ec) {
			/*negative base case, returns arraylist of 
			 * 0 length so nothing happens and boundary is 
			 * created which results in nothing happening
			 */
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();
		
		
		ArrayList<String> rrh = maze(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}
		ArrayList<String> rrv = maze(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}
		return mr;
	}
}
