package BQueue;

import java.util.LinkedList;
import java.util.Scanner;
public class B1021 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LinkedList<Integer> Deque = new LinkedList<Integer>();
		
		int count = 0;
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[M];//뽑을 숫자를 담자
		for (int i = 1; i <= N; i++) {
			Deque.offer(i);
		}
		for (int i = 0; i < M; i++) {
			arr[i]= sc.nextInt();
		}
		
		for(int i=0;i<M;i++) {
			int target_idx = Deque.indexOf(arr[i]);
			int half_idx;
			
			if(Deque.size()%2==0) {
				half_idx = Deque.size()/2 - 1;
			}
			else {
				half_idx = Deque.size()/2;
			}
			
			if(target_idx<=half_idx) {
				for (int j = 0; j < target_idx; j++) {
					int temp =Deque.pollFirst();
					Deque.offerLast(temp);
					count++;
				}
			}
			else
			{
				for (int j = 0; j < Deque.size()-target_idx; j++) {
					int temp =Deque.pollLast();
					Deque.offerFirst(temp);
					count++;
				}
			}
			Deque.pollFirst();
		}
		System.out.println(count);
	}

}
