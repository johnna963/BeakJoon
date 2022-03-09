import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_미로탐색_2178 {
	static int N;
	static int M;
	static int[][] arr;
	static boolean[][] visited;
	static class Node {
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx>=N || ny >= M)
					continue;
				if(visited[nx][ny] || arr[nx][ny] == 0)
					continue;
				queue.add(new Node(nx,ny));
				arr[nx][ny] = arr[node.x][node.y] + 1;
				visited[nx][ny] = true;
			}
		}
	}
}
