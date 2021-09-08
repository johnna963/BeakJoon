package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2583 {
	static int M;
	static int N;
	static int K;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int cnt;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for (int j = y1; j < y2; j++) {
				for (int k = x1; k < x2; k++) {
					map[j][k] = 1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0) {
					cnt = 0;
					DFS(i,j);
					arr.add(cnt);
				}
			}
		}
		Collections.sort(arr);
		sb.append(arr.size()).append("\n");
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i)).append(" ");
		}
		System.out.println(sb);
		
	}
	static void DFS(int y, int x) {
		map[y][x]=2;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0&&ny>=0&&ny<M&&nx<N) {
				if(map[ny][nx] == 0) {
					DFS(ny,nx);
				}
			}
		}
	}
}
