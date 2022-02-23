import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_유기농배추_1012 {
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}	
	}
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			visit = new boolean[m][n];
			int count = 0;
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
			}
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						bfs(i,j,m,n);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	static void bfs(int i, int j,int m,int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(i,j));
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;
			for(int k = 0; k< 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				visit[x][y] = true;
				if(nx >= 0 && ny >= 0 && nx < m && ny < n) {
					if(!visit[nx][ny] && map[nx][ny] == 1) {
						queue.add(new Node(nx,ny));
						visit[nx][ny] = true;
					}
				}
			}
		}
	}
}
