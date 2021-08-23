package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B2468 {
	/**
	 * 물의 높이/dr, dc/구역 카운팅 
	 * 방문했는가? 
	 * 저장은 맥스힙으로 하자
	 * 물의 높이와 방문하지 않았을때 dfs시작
	 * */
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int depth = 0; depth < max; depth++) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]>depth&&!visited[i][j]) {
						cnt++;//탐색할때마다 증가
						dfs(i,j,depth);
					}
				}
			}
			pq.offer(cnt);
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);//depth 증가후 재검토를 위한 배열 초기화
			}
		}
		
		System.out.println(pq.poll());
	}
	static void dfs(int x, int y, int depth) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if(nx>=0 && ny>=0 && nx<N && ny<N&&arr[nx][ny]>depth && !visited[nx][ny]) {
				dfs(nx,ny,depth);
			}
		}
	}
}
