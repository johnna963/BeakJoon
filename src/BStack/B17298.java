package BStack;

import java.util.Scanner;
import java.util.Stack;

public class B17298 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}

		
		for (int i = 0; i < N; i++) {
			/** 시간초과 ...시간을 단축해야한다.
			 * 스택이 비어있으면 스택에 인덱스 값푸쉬
			 * 비어있지 않으면 저장된 인덱스와 배열i번째 비교
			 * 작으면 i 번째 푸쉬
			 * 크면 저장된 인덱스 배열의 i번째 값으로 바꿔줌
			 * 마지막 루프떄 스택에 저장된 배열의 인덱스 값을 모두 -1로 바꿔줌
			 * 3 5 2 7///////////// 0
			 * 5 5 2 7///////////// 1
			 * 5 5 2 7///////////// 1 2
			 * 5 5 7 7///////////// 1
			 * 5 7 7 7///////////// 3
			 * 5 7 7-1/////////////
 			 * */
			while(!stack.empty()&&arr[i]>arr[stack.peek()]) {
				
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		while(!stack.empty()) {
			arr[stack.pop()] = -1;
		}
		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
		
		
	}
}
