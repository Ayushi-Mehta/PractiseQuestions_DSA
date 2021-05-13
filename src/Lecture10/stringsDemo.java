package Lecture10;

import sun.jvm.hotspot.tools.SysPropsDumper;

public class stringsDemo {

	public static void main(String[] args) {
		String str ="hello"; //literal
		//created in intern pool
		
		System.out.println(str);
		
		//length
		System.out.println(str.length());
		//() added in string and arraylist but not in arrays
		
		//charAt
		
		System.out.println(str.charAt(0));
		char ch = str.charAt(2);//return type of charAt is char
		System.out.println(ch);
		
		System.out.println(str.charAt(str.length()-1));
		
		//SUBSTRING->VERY IMP
		String s = str.substring(1,4);//DO NOT USE CHAR HERE
		System.out.println(s);
		
		//subtring(2,2) will give us string having no value and zero length
		System.out.println(str.substring(2,2));//""
		
		System.out.println(str.substring(2));//string printed till from index 2 till end
		
		//System.out.println(str.substring(3,1));//error
		//substring(3,21)->error because string length exceeded
		
		System.err.println(str.substring(1,5));
		//range from 0 to length of string as the second no is not included
		
		
		//index of
		System.out.println(str.indexOf("Ll"));// -1 as it is not present in string
		System.out.println(str.indexOf("lo"));//index of first occurence only
		
		System.out.println(str.lastIndexOf("ll"));//gives index of last occurence
		
		System.out.println(str.startsWith("He"));//false
		System.out.println(str.startsWith("he"));//true
		
		System.out.println(str.endsWith("lo"));//true
		
		//CONCAT
		String s1="hi";
		String s2="bye";
		String s3= s1+s2;
		System.out.println(s1+" " +s2 +" " + s3);
		String s4= s1.concat(s2);
		System.out.println(s4);
		
	}

}
