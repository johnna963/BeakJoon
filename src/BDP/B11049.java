package BDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11049 {
	static int[] raw;
	static int[] col;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		raw = new int[N];
		col = new int[N];
		dp = new int[N][N];//카운트
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			raw[i] = Integer.parseInt(st.nextToken());
			col[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		int min = find_min(0, N-1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		//System.out.println(min);
		
	}
	static int find_min(int start, int end) {
		if(start == end) {
			return 0;
		}
		
		if(dp[start][end] != Integer.MAX_VALUE) {
			return dp[start][end];
		}
		
		for (int i = start; i < end; i++) {
			int cost =find_min(start, i)+find_min(i+1, end) + raw[start] * col[i] * col[end];
			dp[start][end] = Math.min(dp[start][end], cost);
		}
		
		return dp[start][end];
	}
}
