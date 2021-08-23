package BImplement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2567 {
	static int[][] map = new int[101][101];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for (int j = x; j <x + 10; j++) {
				for (int k = y; k <y + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]==1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dr[k];
						int ny = j + dc[k];
						if(nx>=0 && ny>=0 && nx<101 && ny<101) {
							if(map[nx][ny] == 0) {
								answer++;
							}
						}
					}
				}
			}
		}
		System.out.println(answer);	
	}
}
