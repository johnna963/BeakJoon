package BQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1966 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb= new StringBuilder();
		int TestCase = sc.nextInt();
		
	
		while(TestCase-->0) {
			int N = sc.nextInt();//문서 개수
			int M = sc.nextInt();//문서의 위치
			
			LinkedList<int[]> q = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				q.offer(new int[] {i,sc.nextInt()});
			}
			
			int count = 0;
			
			while(!q.isEmpty()) {
				int[] front =q.poll();
				//System.out.println(front[1]);
				boolean isMax = true;
				for (int i = 0; i < q.size(); i++) {
					if(front[1]<q.get(i)[1]) {
						q.offer(front);
						for (int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						
						isMax = false;
						break;
					}
				}
				if(isMax == false){
					continue;
				}
				count++;
				if(front[0]==M) {
					break;
				}
			}
			sb.append(count).append('\n');
		}
		//System.out.println(sb);
		
	}

}
