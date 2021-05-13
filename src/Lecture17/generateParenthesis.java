package Lecture17;

import java.util.ArrayList;
import java.util.Scanner;

public class generateParenthesis {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int n=scn.nextInt();
		ArrayList<String> list=new ArrayList<String>();
		validParr(0,0,n,"",list);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		//System.out.println(list);
	}
	public static void validParr(int open,int close, int n, String ans,ArrayList<String> list) {
		if(open==n && close==n) {//+ve base case
			//System.out.print(ans+" ");
			list.add(ans);
			return;
		}
		if(open>n ||close>open) {//-ve base case
			return;
		}
		
		validParr(open+1,close,n,ans+"(",list);
		validParr(open,close+1,n,ans+")",list);
	}
}
