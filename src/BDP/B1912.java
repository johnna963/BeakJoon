package BDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1912 {
	
	static int[] arr;
	static Object[] dp;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp= new Object[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		max = arr[0];
		recur(N-1);
		
		System.out.println(max);
		
	}
	static int recur(int N) {
		if(dp[N]==null) {
			dp[N] = Math.max(recur(N-1) + arr[N] ,arr[N]);
			max = Math.max((int) dp[N], max);
			System.out.println(dp[N]+" "+max);
		}
		
		return (int) dp[N];
		
	}
}
