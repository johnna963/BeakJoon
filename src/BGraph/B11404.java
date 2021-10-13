package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404 {
	static int N;
	static int M;
	static int INF = 9999999;
	static int[][] Map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		Map = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(i!=j) {
					Map[i][j] = INF;
				}
			}
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(Map[from][to] > cost) {
				Map[from][to] = cost;
			}
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 1; i < N+1; i++) {
				if(k==i) {
					 continue;
				 }
				for (int j = 1; j < N+1; j++) {
					 if(k==j || i==j) {
						 continue;
					 }
					 Map[i][j]  = Math.min(Map[i][j], Map[i][k]+Map[k][j]);
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if(Map[i][j] == INF) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(Map[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
}
