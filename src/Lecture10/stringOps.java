package Lecture10;

import java.util.ArrayList;
import java.util.Scanner;

public class stringOps {

	public static void main(String[] args) {
		System.out.println("give string");
		Scanner scn=new Scanner(System.in);
		String str=scn.nextLine();
		 ArrayList<String> k=countPalindromicSubstrings(str);
	        System.out.print(k);
	        
		//reverse(str);
		//System.out.println(reverse(str));
	}
	public static ArrayList<String> substrings(String str){
		ArrayList<String> list= new ArrayList<String>();
		 for(int si=0;si<str.length();si++) {
			 for(int ei=si+1;ei<=str.length();ei++) {
				 list.add(str.substring(si,ei));
			 }
		 }
		 System.out.print(list+" ");
		 System.out.println();
		 return list;
	}
	public static boolean palindrome(String str) {
		for(int i=0;i<str.length();i++) {
			for(int j=str.length()-1;j>i;j--) {
				if(str.charAt(i) != str.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}
	public static ArrayList<String> countPalindromicSubstrings(String str) {
		int count=0;
		ArrayList<String> list = substrings(str);
		ArrayList<String> rr= new ArrayList<String>();
		for(String val : list) {
			if(palindrome(val)) {
				count++;
				rr.add(val);
			}
		}
		return rr;
	}
	public static void reverse(String str) {
		String ans="";
		while(true) {
			int idx=str.lastIndexOf(' ');
			String word=str.substring(idx+1);
			
			ans=ans+word+" ";
			if(idx==-1) {
				break;
			}
			str=str.substring(0,idx);
		}
		System.out.println(ans);
	}
}
