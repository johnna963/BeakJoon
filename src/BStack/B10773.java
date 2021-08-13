package BStack;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum=0;
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			if(num == 0) {
				stack.pop();
			}
			else {
				stack.push(num);
			}
		}
		for(int i=0;i<stack.size();i++) {
			sum+=stack.get(i);
		}
		System.out.println(sum);
	}
}
