package implementation;

import java.util.Scanner;

public class C3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		C2 c2 = new C2();
		
		try {
			c2.m2(x);
		}
		
		catch(ValueTooSmallException e) {
			
		}
	}
}
