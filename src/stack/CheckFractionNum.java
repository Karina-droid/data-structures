package stack;

import java.util.Scanner;

public class CheckFractionNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a fraction number: ");
		double num = scan.nextDouble();
		System.out.print(checkFractionNum(num));
	}
	
	
	//checks if the num has the same digits before and after the dot
	static boolean checkFractionNum(double num) {
		String s = String.valueOf(num);
		String strInt = s.split("\\.")[0];
		String strRem = s.split("\\.")[1];
		if(strInt.length()!=strRem.length()) return false;
		
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		for(int i=0; i<strInt.length(); i++) {
			s1.push(Integer.parseInt(String.valueOf(strInt.charAt(i))));
			s2.push(Integer.parseInt(String.valueOf(strRem.charAt(i))));
		}for(int i=0; i<strRem.length(); i++) {
			if(s1.pop()!=s2.pop()) return false;
		}return true;
	}
}
