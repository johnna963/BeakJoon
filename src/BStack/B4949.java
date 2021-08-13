package BStack;

import java.util.Scanner;
import java.util.Stack;

public class B4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//스택이 비면 vps 안비면 NOT vps
		String str;
		while(true) {
			str=sc.nextLine();
			if(str.equals(".")) {
				break;
			}
			System.out.println(Solution2(str));
		}
	}
	static String Solution2(String str) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '('||ch == '[') {
				stack.push(ch);
			}
			else if(ch == ')') {
				if(stack.empty()||stack.peek()!='(')
				return "no";
				else
					stack.pop();
			}
			else if(ch == ']') {
				if(stack.empty()||stack.peek()!='[')
					return "no";
					else
						stack.pop();
			}
			
		}
		if(stack.empty()) {
			return "yes";
		}
		else
			return "no";
		
	}

}

