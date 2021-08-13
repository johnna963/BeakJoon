package BStack;

import java.util.Scanner;
import java.util.Stack;

public class B9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//스택이 비면 vps 안비면 NOT vps
		int N = sc.nextInt();//문자열 횟수
		String str;
		for(int i=0;i<N;i++) {
			str=sc.next();
			System.out.println(Solution(str));
		}
	}
	static String Solution(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			}
			else if(stack.empty()) {
				return "NO";
			}
			else {
				stack.pop();
			}
		}
		if(stack.empty()) {
			return "YES";
		}
		else
			return "NO";
		
	}

}
