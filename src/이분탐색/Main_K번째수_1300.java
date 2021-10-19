package 이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_K번째수_1300 {
	static int N;
	static int K;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
//		for (int i = 1; i < N+1; i++) {
//			for (int j = 1; j < N+1; j++) {
//				A[i-1][j-1] = i*j;
//				0//0 0 0 0	(1+k)/i N
//				1//0 1 2 3 || 4/1 3
//				2//0 2 4 6 || 4/2 3 
//				3//0 3 6 9 || 4/3 3
//			}	
//		}
		long left = 1;
		long right = K;
		long answer = binarysearch(left, right);
		System.out.println(answer);
	}
	static long binarysearch(long left, long right) {
		int cnt = 0;
		
		long mid = (left + right) / 2;
		for (int i = 1; i <= N; i++) {
			cnt += Math.min(mid/i, N);
		}
		if(left > right) {
			return ans;
		}
		if(K <= cnt) {
			//이 구역안엔 답이 있고
			ans = mid;
			return binarysearch(left, mid-1);
		}
		else {
			//이 구역안엔 답이없다.
			//ans = mid;
			return binarysearch(mid+1, right);
		}
	}
}
