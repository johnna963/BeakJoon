package BQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2164 {

	public static void main(String[] args) {
		System.out.println("시작");
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(q.size() != 1) {
			int save;
			q.remove();
			save = q.poll();
			
			q.add(save);
			
		}
		System.out.println(q.poll());
	}

}
