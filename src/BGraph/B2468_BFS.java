package BGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468_BFS {
	//380ms
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
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		for (int depth = 0; depth < max; depth++) {
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]>depth&&!visited[i][j]) {
						cnt++;//탐색할때마다 증가
						bfs(i,j,depth);
					}
				}
			}
			pq.offer(cnt);
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], false);
			}
		}
		System.out.println(pq.poll());
	}
	static void bfs(int x, int y, int depth) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] data = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = data[0] + dr[i];
				int ny = data[1] + dc[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					if(!visited[nx][ny] && arr[nx][ny] > depth) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
		}
	}
}
