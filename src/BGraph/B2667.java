package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B2667 {
	/**단지번호 붙이기
	 * 간단한 dfs문제
	 * 332ms*/
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt;
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		int num = 1;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if(!visited[i][j] && map[i][j] != 0) {
					cnt = 0;
					dfs(i,j,num);
					arr.add(cnt);
					num++;
				}
			}
			
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	static void dfs(int x, int y, int num) {
		visited[x][y] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(!visited[nx][ny] && map[nx][ny] != 0) {
					map[nx][ny] = num;
					dfs(nx,ny,num);
				}
			}
		}
	}
}
