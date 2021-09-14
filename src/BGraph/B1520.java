package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1520 {
	/**
	 * 내리막길 
	 * 항상 내리막으로 마지막까지 도달하는 경로를 구하라
	 * */
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int road;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				dp[i][j] = -1;
			}
		}
		road = dfs(0,0);
		System.out.println(road);
	}
	static int dfs(int x, int y) {
		if(x == N-1 && y == M-1) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
				if(map[nx][ny]<map[x][y]) {
					dp[x][y] += dfs(nx,ny);
				}
			}
		}
		return dp[x][y];
	}
}
