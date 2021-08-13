package BQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11866 {

	public static void main(String[] args) {
		//1 ~N 명이 원을 이루고 앉음
		//k를 주고 k 번째를 제거 반복
		//제거되는 순서 요세푸스 수열
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		sb.append("<");
		while(q.size()!=1) {
			
			for (int i = 0; i < K - 1; i++) {
				int val = q.poll();
				q.add(val);
			}
			sb.append(q.poll()).append(", ");
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
		
	}

}
