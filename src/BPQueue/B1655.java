package BPQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B1655 {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			PriorityQueue<Integer> h_max = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> h_min = new PriorityQueue<>();
			/**제한시간 0.1초 힙하나론 시간이 오래걸린다.
			 * h_max 에 작은 값 h_min 에 큰값
			 * h_max 제일 앞의 값이 중간값이 될것
			 * */ 
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				if(i%2==0) {
					h_max.add(num);
				}
				else {
					h_min.add(num);
				}
				while(!h_max.isEmpty()&&!h_min.isEmpty()&&h_max.peek()>h_min.peek()) {
					int temp = h_max.poll();
					h_max.add(h_min.poll());
					h_min.add(temp);
				}
				sb.append(h_max.peek()).append("\n");	
			}	
			System.out.print(sb);
	}
}
