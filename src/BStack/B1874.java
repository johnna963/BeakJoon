package BStack;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
	/**스택엔 오름차순으로 저장 
	 * 원하는 숫자가 나올시 pop
	 * start는 오름차순 정렬 어디까지 넣었는가
	 * value는 내가 pop해야되는 값
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int start = 0;
		
		while(N-->0) {
			int value = sc.nextInt();
			if(value>start) {
				for(int i=start+1;i<=value;i++) {
					stack.push(i);
					sb.append('+').append('\n');
				}
				start = value;
			}
			else if(stack.peek()!=value) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append('-').append('\n');
		}
		System.out.println(sb);
	}
}
